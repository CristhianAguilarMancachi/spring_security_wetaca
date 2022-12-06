package bo.edu.ucb.sis213.wetaca.dto;

public class CreateUsuarioDto {
    private String ciuser;
    private String firstName;
    private String lastName;
    private String email;
    private String fono;
    private String username;
    private String secret;

    public CreateUsuarioDto() {
    }

    public String getCiuser(){
        return ciuser;
    }

    public void setCiuser(String ciuser){
        this.ciuser = ciuser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFono(){
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }


    public String getSecret() {
        return secret;
    }
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Override
    public String toString() {
        return "CreateUsuarioDto{" +
                " ciuser='" + ciuser + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", fono='" + fono + '\'' +
                ", username='" + username + '\'' +
                ", secret='" + secret + '\'' +
                '}';
    }
}
