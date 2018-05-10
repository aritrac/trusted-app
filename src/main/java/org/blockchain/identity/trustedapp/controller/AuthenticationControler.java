package org.blockchain.identity.trustedapp.controller;

import org.blockchain.identity.trustedapp.feature.AuthenticationService;
import org.blockchain.identity.trustedapp.feature.Transaction;
import org.blockchain.identity.trustedapp.feature.TransactionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationControler {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String authenticate(Model model) {
        String[] values = authenticationService.getQrCodeAndTxIdFromIdentityServer();
        TransactionRegistry.getInstance().put(values[1], new Transaction(values[1]));
        model.addAttribute("qr", values[0]);
        model.addAttribute("txId", values[1]);
        return "authenticate";
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.POST)
    public ModelAndView showUser(@RequestParam("txId") String txId, ModelMap model) {
        Transaction transaction = TransactionRegistry.getInstance().get(txId);
        if(transaction != null && transaction.getUserInfo() != null) {
            model.addAttribute("email", transaction.getUserInfo().getEmail());
            return new ModelAndView("userinfo", model);
        } else {
            return new ModelAndView("redirect:/");
        }
    }
}
