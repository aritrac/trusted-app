package org.blockchain.identity.trustedapp.rest;

import org.springframework.web.bind.annotation.*;

@RestController
public class DataReceiverController {

    @RequestMapping(value = "receive", method = RequestMethod.POST, produces = "application/json")
    public void receivedClientInfo(@RequestBody ClientInfo clientInfo) {

    }

    @RequestMapping(value = "is-received")
    public boolean isInfoReceived(@RequestParam String txId) {
        return false;
    }
}
