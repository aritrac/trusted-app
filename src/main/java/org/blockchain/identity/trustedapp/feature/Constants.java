package org.blockchain.identity.trustedapp.feature;

public interface Constants {

    static final String SERVER_BASE_URL = "http://localhost:8080";
    public static final String AUTHN_INITIATE_API = SERVER_BASE_URL + "/initiate";
    public static final String VERIFY_USER_API = SERVER_BASE_URL + "/verify-user";
}
