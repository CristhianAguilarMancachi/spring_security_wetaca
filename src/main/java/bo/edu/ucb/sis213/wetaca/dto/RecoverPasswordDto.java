package bo.edu.ucb.sis213.wetaca.dto;

public class RecoverPasswordDto {
    private String email;
    private String secret;

    public RecoverPasswordDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "RecoverPasswordDto{" +
                "email='" + email + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
