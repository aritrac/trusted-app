package org.blockchain.identity.trustedapp.feature;

public class PartnerInfo {
    private static final String partnerId;
    private static final String privateKey;
    private static final String publicKey;

    private static final String serverPublicKey;

    static {
        partnerId = "GdXmmidivpDpJjKCracYbuLRmXzHuKeq";
        privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCS7JCqoObPGB7NW3tGn2r+sL0y0LLALRLY+L1LvGFQZy5Mlw7fp1GBeGkSClBAt+fUOL09q5vSsf+x/MjdQmMHvIYOks784hkvVBVQBnnO7f9CaAfXnavjTw4BuovCGLA44t76HnzAlnn9gEl2oxTUO6xW4zUT4XhUDG5ELdiNMN9lAuzn3xmk6jc0eGApCXvhoF1ujC9PLYMYv9usATRw1U0SCtuZAQlQitRhlSyrMPixNoAxgz8fEgcvAAgcUqkheERsmtLgjFoDh2nyIFgvkNrAwFMdtM/A9eb0R/9YqYI9k3+CuPw3zNePm6kp7LQ0X2jcclklmOmRiVdlgbY/AgMBAAECggEALdmte9IitVYtpqB55Bwz4698G7ONVPO8AgH98Pik1dadWEF73sf0Y5cUExEs4kWCD3R1eh1nz2TFCuJ8PLBO/0cR/tJJzhkxCtgOnp6mvLEBC9QzPlJyJcmx8VAp9TSHKfmC5ENHY0KSZ031nxRdl63XpnXZRo8CYhhPAO/duJGiViRpQkNxnlRKGD1YZAs/SSzAIrVA3wRRT7VOo4XtwDadfb+R+poapfWymafs4RTZ93ur5bi9+I2qqaLHGX5Hi/WEKPKl3Wpb6qbXP1MixYTqNFmDR+5QURdcQBG1lW1bQT7R2A/WdJCe/hx11L+hPMivkFSxPCXb5Gi+9EWkoQKBgQDUpPPoIvKUYO8Bep9wdYG/2gSTKOrzoQHFJoWmkn3PR3hCbdlG7UK+dhiSom14vVBy7H2Epw4ECM8Q5/SYQ8IvOMF/RVMG5swEsKZW+JJDrzOEn5fnB3BI8TGGBnOwPnT1X0hMMsf1o+HbAk/zYNyH2x2KTSncUsVsJx69vqdvYwKBgQCw4VHeFTmT0DL7FtTfdjNtd4+oO3LTLyHf15u2HZydHH3D1wzIqjCu46eSnYcNMEvUxbQVaKdaaeFjb3theREJ+l/zL4Gw1nNC4sqeo4Hv8XkgvaAXJx7sDrUKd8sgMvPNn9UZsPP/kCyhvl6i/p4+HicHQKwnfxKtAJ0gktFadQKBgEThbfS7JVL1F1amTvFRzwbDa4nzzi++7uDa+p4bg89Z+lWiWaiFAILLpGgTX1ymDmI7wujuaDbcV57FVFDiWguL2foNDbkFl/7I7gjsGgz8urZyL/VxTmkCYCVm/6COirpU9Alixa0HOgkEdbuDm8wSKT58glvRIAxJm8ag9IG7AoGBAK1WIcRhSGtyPIOTfEkArKU55a4XlA8gwTF7OTzfB/tvUE/7DqwXHF5G+pDTjuV9ztJUbIYOaPJRkG7BcUe0PN5qXl0S0SVbAtkpJycPVOau3OUY7ynBTKxIPWJkwsprJED9wPfMUVDBGPvocxWIL8rwAY858XtDLCodz918A22BAoGAH9rmgwRmlkq1ICC+USvjQUONrVqxQ6unMpEvqrl47bWIuG7CdtIjixtSB3uF/tRly2wfQil3UL1Vk1Wf8IQ+IOvUn6xYsx++Ex34XlPpagFlPcSkvQTte9Oa+Ve5B10C8DnuC3fWT3A0KZZLmSMfJ5WuDt6dnBS9J50rDcKXK04=";
        publicKey = "-----BEGIN CERTIFICATE-----\n" +
                "MIIC6TCCAdGgAwIBAgIJAMHq0xBQLizBMA0GCSqGSIb3DQEBCwUAMDQxCzAJBgNV\n" +
                "BAYTAklOMQswCQYDVQQKEwJDQTELMAkGA1UECxMCQ0ExCzAJBgNVBAMTAkNBMB4X\n" +
                "DTE4MDUwOTA5NDcwNVoXDTI4MDUwNjA5NDcwNVowNDELMAkGA1UEBhMCSU4xCzAJ\n" +
                "BgNVBAoTAkNBMQswCQYDVQQLEwJDQTELMAkGA1UEAxMCQ0EwggEiMA0GCSqGSIb3\n" +
                "DQEBAQUAA4IBDwAwggEKAoIBAQCS7JCqoObPGB7NW3tGn2r+sL0y0LLALRLY+L1L\n" +
                "vGFQZy5Mlw7fp1GBeGkSClBAt+fUOL09q5vSsf+x/MjdQmMHvIYOks784hkvVBVQ\n" +
                "BnnO7f9CaAfXnavjTw4BuovCGLA44t76HnzAlnn9gEl2oxTUO6xW4zUT4XhUDG5E\n" +
                "LdiNMN9lAuzn3xmk6jc0eGApCXvhoF1ujC9PLYMYv9usATRw1U0SCtuZAQlQitRh\n" +
                "lSyrMPixNoAxgz8fEgcvAAgcUqkheERsmtLgjFoDh2nyIFgvkNrAwFMdtM/A9eb0\n" +
                "R/9YqYI9k3+CuPw3zNePm6kp7LQ0X2jcclklmOmRiVdlgbY/AgMBAAEwDQYJKoZI\n" +
                "hvcNAQELBQADggEBAHS0Ahl0mRUPA8VAwvJYEpgJmuLkSC3J86+n6qeQx0c62LQY\n" +
                "ZZoFqFAbZ7+IHzGkYKuce15KJKgu9wBny/j6rSXjmj1J/z42wMdRff6q3jRpea73\n" +
                "HistEbFBdgAHV5zfL4k1eGNoXoB2/q9YpHBhEtZ6lYGt9j1Y79ZG0KLyIbAAD+m7\n" +
                "faG9HA+AaPIUVNl8AzdXah81lqSwUICKLEIpNjdl9nhq1VgKL+nEEih7GjAhg4lP\n" +
                "bIXF/9+Gj0DqAhgs3t2drtS3LhqURFt+OFrpxkKpNqkQOLJcKriotmZgtc5ZILxl\n" +
                "kY47Qmfg5hIUEBsvjeOjwv5rcxH8NvXgsWs2llY=\n" +
                "-----END CERTIFICATE-----";

        serverPublicKey = "-----BEGIN CERTIFICATE-----\n" +
                "MIIC6TCCAdGgAwIBAgIJAKKwaxCpBXXSMA0GCSqGSIb3DQEBCwUAMDQxCzAJBgNV\n" +
                "BAYTAklOMQswCQYDVQQKEwJDQTELMAkGA1UECxMCQ0ExCzAJBgNVBAMTAkNBMB4X\n" +
                "DTE4MDUwOTA5NTAxOFoXDTI4MDUwNjA5NTAxOFowNDELMAkGA1UEBhMCSU4xCzAJ\n" +
                "BgNVBAoTAkNBMQswCQYDVQQLEwJDQTELMAkGA1UEAxMCQ0EwggEiMA0GCSqGSIb3\n" +
                "DQEBAQUAA4IBDwAwggEKAoIBAQC4IBKqAmoH6saPHJ0pi/ggzvr9XUXIvC8zDZG5\n" +
                "OxACAdfRl0ubKzqeR/Hhov0JxngLSkZTGXori5D5zDMEzZXSs4Z/dY2LKZckbQVI\n" +
                "7rySQMAE9bS00jXT14CNEqh1S/OU3q///ePWchE4y7kPo0gRXtvzOTA7/PuUMHO9\n" +
                "YccSicUL7icq3scCgzpBNYtOIMJuhhK0dwA7ch248mQtiEC+fC/Twu+E/qw2WI2I\n" +
                "kexmjpObz0KDpdD3KJ5Zq9/KqcxjbgX0J5shnB9keEY++s18m2kvphp5/kfq97fK\n" +
                "45u6tG0jYm4nHQxsGaY1HYLGbaV8nGHbXWPXMMsLzfm/iPAvAgMBAAEwDQYJKoZI\n" +
                "hvcNAQELBQADggEBADhwn7Z3UTF/nDBhTmCSZOD/hHuFihP0qWJ/CM58GB7nqryy\n" +
                "jA3rILTc3ytKZ7yLS+iOrXfmpRZg1bbzJ3VUdNG32lT20Bacbo0Y5Pdi1QkVZ93/\n" +
                "zEduMKXNaGkwfibGr1wpl5umYIYwRrN39nl+SWlad2JnXoUkqPhORnUX/XXUupUJ\n" +
                "F/fS3V5bfGiNUo1E+gK1UXZIEozHQTYogtSPH8Wi1XuPajZ35ZY63w09w/sNudvS\n" +
                "blMi7MPq1HNX6WrtdpuoKL6ZgLBRFxbF5xAKQHVNeLG/eD6cXJVkJk3z69rfsHhw\n" +
                "94b2J1vbyrasW6Djg8GRUKsVqiyOL5aXLc2XNJg=\n" +
                "-----END CERTIFICATE-----";
    }

    public static String getPartnerId() {
        return partnerId;
    }

    public static String getPrivateKey() {
        return privateKey;
    }

    public static String getPublicKey() {
        return publicKey;
    }

    public static String getServerPublicKey() {
        return serverPublicKey;
    }
}
