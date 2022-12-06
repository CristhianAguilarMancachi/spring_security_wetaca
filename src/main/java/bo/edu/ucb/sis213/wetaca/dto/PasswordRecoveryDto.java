package bo.edu.ucb.sis213.wetaca.dto;

public class PasswordRecoveryDto {
    private int recoveryAttempId;
    private String email; //Debido a que debe ser unico, se usa para obtener el id del usuario
    private String codeHash;
    private String expirationDate;


    public PasswordRecoveryDto() {
    }

    public PasswordRecoveryDto(int recoveryAttempId, String email, String codeHash, String expirationDate) {
        this.recoveryAttempId = recoveryAttempId;
        this.email = email;
        this.codeHash = codeHash;
        this.expirationDate = expirationDate;
    }

    public int getRecoveryAttempId() {
        return recoveryAttempId;
    }

    public void setRecoveryAttempId(int recoveryAttempId) {
        this.recoveryAttempId = recoveryAttempId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCodeHash() {
        return codeHash;
    }

    public void setCodeHash(String codeHash) {
        this.codeHash = codeHash;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PasswordRecoveryDto{" +
                "recoveryAttempId=" + recoveryAttempId +
                ", email='" + email + '\'' +
                ", codeHash='" + codeHash + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }
}
