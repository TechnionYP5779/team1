package il.org.spartan.utils;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

import org.apache.commons.io.*;
import org.json.*;



public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
//    String s = IOUtils.toString(rd), $ = s.substring(s.indexOf('\n') + 1);
//    return $.substring(0, $.lastIndexOf('\n'));
    return IOUtils.toString(rd);
  }
  
//Had to used suppress warning since the address is always available and finally close has to happen
  @SuppressWarnings("resource") public static JSONArray readJsonFromUrl(String url) {
    
    InputStream $ = null;
    try {
      $ = new URL(url).openStream();
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    try {
      return new JSONArray(readAll(new BufferedReader(extracted($))));
    } catch (JSONException | IOException ¢) {
      // TODO Auto-generated catch block
      ¢.printStackTrace();
    } finally {
      try {
        // can't use azzert.notNull($) since warning regarding $ being null still appears.
        assert $ != null;
        $.close();
      } catch (IOException ¢) {
        // TODO Auto-generated catch block
        ¢.printStackTrace();
      }
    }
    return null;
  }

  private static InputStreamReader extracted(InputStream $) {
    return new InputStreamReader($, Charset.forName("UTF-8"));
  }
}