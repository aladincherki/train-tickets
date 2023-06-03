package traintickets.dto;

import com.sun.istack.NotNull;

public class SignUpDto {

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String login;

    @NotNull
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    private char[] password;

    public SignUpDto() {
        super();
    }

    public SignUpDto(@NotNull String firstName, @NotNull String lastName, @NotNull String login, @NotNull char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }
}
