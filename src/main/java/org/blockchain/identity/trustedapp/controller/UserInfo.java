package org.blockchain.identity.trustedapp.controller;

import java.io.Serializable;

public class UserInfo implements Serializable {

    private String txId;
    private String email;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "txId='" + txId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
