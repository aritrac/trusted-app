package org.blockchain.identity.trustedapp.controller;

public class ClientInfo {
    private String email;
    private String txId;

    public ClientInfo(String email, String txId) {
        this.email = email;
        this.txId = txId;
    }

    public ClientInfo() {

    }
}
