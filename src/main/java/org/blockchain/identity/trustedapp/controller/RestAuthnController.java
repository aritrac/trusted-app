package org.blockchain.identity.trustedapp.controller;

import org.blockchain.identity.trustedapp.feature.AuthenticationService;
import org.blockchain.identity.trustedapp.feature.Transaction;
import org.blockchain.identity.trustedapp.feature.TransactionRegistry;
import org.jose4j.json.internal.json_simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestAuthnController {

    @Autowired
    private AuthenticationService service;

    @RequestMapping(value = "/receive", method = RequestMethod.POST, produces = "application/json")
    public void receiveUserInfo(@RequestBody UserInfo userInfo) {
        System.out.println(userInfo);
        service.verifyUserInfo(userInfo);
    }

    @RequestMapping(value = "/verified", method = RequestMethod.GET)
    public String isUserVerified(@RequestParam("txId") String txId) {
        Transaction transaction = TransactionRegistry.getInstance().get(txId);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", transaction != null && transaction.getUserInfo() != null);
        return jsonObject.toJSONString();
    }
}
