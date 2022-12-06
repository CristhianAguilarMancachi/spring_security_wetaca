package bo.edu.ucb.sis213.wetaca.entity;

import java.util.Date;

public class WcPasswordRecovery {
    private int recoveryAttempId;
    private int userId;
    private String codeHash;
    private Date expirationDate;
    private int status;
    private String txUser;
    private String txHost;
    private Date txDate;

    public WcPasswordRecovery() {
    }

    public WcPasswordRecovery(int recoveryAttempId, int userId, String codeHash, Date expirationDate, int status, String txUser, String txHost, Date txDate) {
        this.recoveryAttempId = recoveryAttempId;
        this.userId = userId;
        this.codeHash = codeHash;
        this.expirationDate = expirationDate;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public int getRecoveryAttempId() {
        return recoveryAttempId;
    }

    public void setRecoveryAttempId(int recoveryAttempId) {
        this.recoveryAttempId = recoveryAttempId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCodeHash() {
        return codeHash;
    }

    public void setCodeHash(String codeHash) {
        this.codeHash = codeHash;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTxUser() {
        return txUser;
    }

    public void setTxUser(String txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    @Override
    public String toString() {
        return "FrPasswordRecovery{" +
                "recoveryAttempId=" + recoveryAttempId +
                ", userId=" + userId +
                ", codeHash='" + codeHash + '\'' +
                ", expirationDate=" + expirationDate +
                ", status=" + status +
                ", txUser='" + txUser + '\'' +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}

