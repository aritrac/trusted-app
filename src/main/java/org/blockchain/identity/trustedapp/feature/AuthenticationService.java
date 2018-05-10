package org.blockchain.identity.trustedapp.feature;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.blockchain.identity.trustedapp.controller.UserInfo;
import org.jose4j.jwt.JwtClaims;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {

    public String[] getQrCodeAndTxIdFromIdentityServer() {
        try {
            Map<String, String> data = new HashMap<>();
            data.put("partnerId", PartnerInfo.getPartnerId());
            String jwtToken = JwtUtils.createJwtToken(PartnerInfo.getPartnerId(), data, KeyUtils.getPrivateKey(PartnerInfo
                    .getPrivateKey()));
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.postForEntity(Constants.AUTHN_INITIATE_API, jwtToken,
                    String.class);
            String jwtPayload = response.getBody();
            JwtClaims jwtClaims = JwtUtils.verifyJwtResponse(jwtPayload, KeyUtils.getPublicKey(PartnerInfo
                    .getServerPublicKey()));
            String qr = jwtClaims.getStringClaimValue("qr");
            String txId = jwtClaims.getStringClaimValue("txId");
            return new String[] {qr, txId};
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void verifyUserInfo(UserInfo userInfo) {
        Transaction transaction = TransactionRegistry.getInstance().get(userInfo.getTxId());
        System.out.println(transaction);
        if(transaction != null) {
            try {
                Map<String, String> data = new HashMap<>();
                data.put("txId", userInfo.getTxId());
                data.put("hash", DigestUtils.sha256Hex(userInfo.getEmail()));
                String jwtToken = JwtUtils.createJwtToken(PartnerInfo.getPartnerId(), data, KeyUtils.getPrivateKey(PartnerInfo
                        .getPrivateKey()));
                RestTemplate restTemplate = new RestTemplate();
                ResponseEntity<String> response = restTemplate.postForEntity(Constants.VERIFY_USER_API, jwtToken,
                        String.class);
                String jwtPayload = response.getBody();
                JwtClaims jwtClaims = JwtUtils.verifyJwtResponse(jwtPayload, KeyUtils.getPublicKey(PartnerInfo
                        .getServerPublicKey()));
                boolean verifiedUser = BooleanUtils.toBoolean(jwtClaims.getStringClaimValue("verified"));
                if(verifiedUser) {
                    transaction.setUserInfo(userInfo);
                    TransactionRegistry.getInstance().put(userInfo.getTxId(), transaction);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
