package traintickets.dto;

public class CredentialsDto {
    private String login;
    private char[] password;

    public String getLogin() {
        return login;
    }

    public CredentialsDto(String login, char[] password) {
        this.login = login;
        this.password = password;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
