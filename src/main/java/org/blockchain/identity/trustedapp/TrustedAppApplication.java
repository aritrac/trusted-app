package org.blockchain.identity.trustedapp;

import org.blockchain.identity.trustedapp.feature.PartnerInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
@ComponentScan("org.blockchain.identity.trustedapp")
public class TrustedAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrustedAppApplication.class, args);
		//System.out.println(PartnerInfo.getServerPublicKey());
	}

}
