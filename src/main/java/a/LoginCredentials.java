package a;

public class LoginCredentials {
  private final String username;
  private final String password;

  public LoginCredentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}
