#r "System.Data"
#r "Newtonsoft.Json"
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Primitives;
using System.Net;
using System.Data;
using System.Data.SqlClient;
using Newtonsoft.Json.Linq;
using System.Text;
using Newtonsoft.Json;
using Google.Apis.Dialogflow.v2.Data;
using Google.Protobuf.WellKnownTypes;
using Google.Cloud.Dialogflow.V2;
// ===================================================================================
//                      THE MAIN TRIGGERED BY THE HTTP
// ===================================================================================
public static async Task<Microsoft.AspNetCore.Mvc.ContentResult> Run(HttpRequest req, ILogger log)
{
    //===================================
    //       SOME IMPORTANT VARIABLES
    const string BUSINESS_HOUR_BY_DAY = "technion.businesses.getSpecific";
    const string BUSINESS_HOUR_WEEK = "technion.businesses.fullweek";
    var resultText = new StringBuilder();
    var cnnString ="CONNECTION_STRING";
    //===================================
    //         USER INPUT HANDLER
    string requestBody = await new StreamReader(req.Body).ReadToEndAsync();
    dynamic data = JsonConvert.DeserializeObject(requestBody);
    string intentName = (data.queryResult.intent.displayName).ToString();
    //===================================
    //         SWITCH BY INTENT
    switch(intentName){
        case BUSINESS_HOUR_BY_DAY: 
            goto BUSISINESS_HOURS_DAILY; // getBusinessHoursByDay
        case BUSINESS_HOUR_WEEK: 
            goto BUSINESS_HOURS_WEEK; //getBusinessHours
        default:
         resultText.Append("what is this intent ?!");
        goto Return_Result;
    }


    //===================================
	//        INTENT HANDLERS
    BUSINESS_HOURS_WEEK:
        string bname = ((data.queryResult).parameters.Business).ToString();
        resultText = HandleBusinessHourWeekly(cnnString,resultText,bname);
        goto Return_Result;


    BUSISINESS_HOURS_DAILY:
        string day = ((data.queryResult).parameters.DayOfWeek).ToString();
        bname = ((data.queryResult).parameters.Business).ToString();
        resultText = HandleBussinessHourByDay(cnnString,resultText,day,bname);

    Return_Result:
        var jsonResponse = createWebhookResponseContent(resultText);
        return new ContentResult { Content = jsonResponse, ContentType = "application/json" };
}

/*  ===================================================================================
* @param cnnstring - for the azure DB
* @param resultText - a stringBuilder
* @param bname - business name we want to look into
* this function returns the weekly business hours.
    ===================================================================================
*/
public static StringBuilder HandleBusinessHourWeekly(string cnnString,StringBuilder resultText, string bname){
    if(bname == null){
        resultText.Append("please choose a business to look into");
        return resultText;
    }
    var jsonResult = new StringBuilder();
    using (SqlConnection conn = new SqlConnection(cnnString) )
    {
        conn.Open();
        var sqlQuery = "SELECT Sunday,Monday,Tuesday,Wednesday,Thursday,Friday,Saturday FROM Businesses"+
        " WHERE CHARINDEX('"+bname+"',BusinessName) != 0";
        using (SqlCommand cmd = new SqlCommand(sqlQuery, conn))
        {
            using (SqlDataReader reader = cmd.ExecuteReader()) {
                if (reader.HasRows){
                    while (reader.Read()){
                        jsonResult.Append(bname+" is open at the following hours:\n");
                        for(int i=0; i<7; i++){
                            if(reader[i].ToString() != "N\\A"){
                                jsonResult.Append(String.Format("On {1}s, between {0}.\n",reader[i], fromIntToDay(i)));
                                resultText = jsonResult; 
                            }
                        }
                    }
                }
                else{
                    resultText.Append("No such business found. If this is an error please contact technionbot1@gmail.com");
                }
            }
        }
    }
    return resultText;
}

/*  ===================================================================================
* @param cnnstring - for the azure DB
* @param resultText - a stringBuilder
* @param day - day of the week we want to get the business hours
* @param bname - business name we want to look into
* this function returns the business hours at a given day of a business.
    ===================================================================================
*/
public static StringBuilder HandleBussinessHourByDay(string cnnString,StringBuilder resultText,string day,string bname){
    if(bname == null){
        resultText.Append("please choose a business to look into");
        return resultText;
    }
    //===================================
    string [] days_of_week = new string[7]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    day = day.First().ToString().ToUpper() + day.Substring(1);
    if(-1 == Array.IndexOf(days_of_week, day))
    {
        resultText.Append("please choose a valid day of the week");
        return resultText;
    }
    //===================================
    var jsonResult = new StringBuilder();
    using (SqlConnection conn = new SqlConnection(cnnString) )
    {
        conn.Open();
        var sqlQuery = "SELECT BusinessName,"+day+" FROM Businesses"+
        " WHERE CHARINDEX('"+bname+"',BusinessName) != 0";
        using (SqlCommand cmd = new SqlCommand(sqlQuery, conn))
        {
            using (SqlDataReader reader = cmd.ExecuteReader()) {
                if (reader.HasRows){
                    while (reader.Read()){
                        if(reader[1].ToString() != "N\\A")
                        {
                            jsonResult.Append(String.Format("The {0} is open between {1} on "+day+"s",
                            reader[0], reader[1]));
                            resultText = jsonResult;                            
                        }
                        else{
                            resultText.Append(String.Format("{0} is not open on "+day+"s",reader[0]));    
                        }
                    }
                }
                else{
                    resultText.Append("No such business found. If this is an error please contact technionbot1@gmail.com");
                }
            }
        }
    }
    return resultText;
}


/*  ===================================================================================
* @param resultText - a stringBuilder contains the string to be displayed to the user
* this function creates the string to return to DialogFlow, matching the DialogFlow expected template.
    ===================================================================================
*/
public static string createWebhookResponseContent(StringBuilder resultText){
    var googlePayload = new Struct
    {
        Fields = { { "expectUserResponse", Value.ForBool(true) } }
    };

    var dialogflowResponse = new WebhookResponse
        {
            Payload = new Struct
            {
                Fields = { { "google", Value.ForStruct(googlePayload) } }
            },
            FulfillmentText = resultText.ToString(),
            FulfillmentMessages =
                { new Intent.Types.Message
                    { SimpleResponses = new Intent.Types.Message.Types.SimpleResponses
                        { SimpleResponses_ =
                            { new Intent.Types.Message.Types.SimpleResponse
                                {
                                   DisplayText = "display text",
                                   TextToSpeech = "display text",
                                }
                            }
                        }
                    }
            }
        };
    var jsonResponse = dialogflowResponse.ToString();
    return jsonResponse;
}

/*  ===================================================================================
* @param i - an integer representing the location of day in the array of week.
* this function returns a string to match this integer.
    ===================================================================================
*/
public static string fromIntToDay(int i){
    switch(i){
    case 0: return "Sunday";
    case 1: return "Monday";
    case 2: return "Tuesday";
    case 3: return "Wednesday";
    case 4: return "Thursday";
    case 5: return "Friday";
    case 6: return "Saturday";
    }
    return "NO DATE";
}