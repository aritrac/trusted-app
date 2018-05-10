package org.blockchain.identity.trustedapp.feature;

import org.blockchain.identity.trustedapp.controller.UserInfo;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String txId;
    private UserInfo userInfo;

    public Transaction(String txId) {
        this.txId = txId;
    }

    public String getTxId() {
        return txId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txId='" + txId + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
