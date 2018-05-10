package org.blockchain.identity.trustedapp.feature;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import sun.security.x509.AlgorithmId;
import sun.security.x509.X500Name;

import javax.security.auth.x500.X500Principal;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

public class KeyUtils {

    public static String formatCertificate(String certificate) {
        String BEGIN_CERTIFICATE = "BEGIN CERTIFICATE";
        String END_CERTIFICATE = "END CERTIFICATE";
        if (StringUtils.isNotBlank(certificate)) {
            certificate = StringUtils.remove(certificate, "\r");
            certificate = StringUtils.remove(certificate, "\n");
            certificate = StringUtils.remove(certificate, "-");
            certificate = StringUtils.remove(certificate, BEGIN_CERTIFICATE);
            certificate = StringUtils.remove(certificate, END_CERTIFICATE);
            certificate = StringUtils.remove(certificate, " ");
            Base64 encoder = new Base64(64);
            certificate = encoder.encodeToString(Base64.decodeBase64(certificate));
            StringBuilder cert = new StringBuilder();
            cert.append("-----").append(BEGIN_CERTIFICATE).append("-----\r\n");
            cert.append(certificate);
            cert.append("-----").append(END_CERTIFICATE).append("-----");
            return cert.toString();
        }
        return certificate;
    }

    public static PrivateKey getPrivateKey(String privateKey) throws NoSuchAlgorithmException,
            InvalidKeySpecException {
        if (StringUtils.isNotBlank(privateKey)) {
            privateKey = deserializePrivateCertificate(privateKey);
            byte[] bytes = org.apache.commons.codec.binary.Base64.decodeBase64(privateKey);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(bytes);
            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(spec);
        }
        return null;
    }

    public static PublicKey getPublicKey(String publicKey) throws NoSuchAlgorithmException,
            InvalidKeySpecException, IOException, CertificateException {
        if (StringUtils.isNotBlank(publicKey)) {
            publicKey = formatCertificate(publicKey);
            CertificateFactory fact = CertificateFactory.getInstance("X.509");
            InputStream is = new ByteArrayInputStream(publicKey.getBytes());
            X509Certificate cer = (X509Certificate) fact.generateCertificate(is);
            PublicKey key = cer.getPublicKey();
            return key;
        }
        return null;
    }

    public static String deserializePrivateCertificate(String certificate) {
        String BEGIN_CERTIFICATE = "BEGIN PRIVATE KEY";
        String BEGIN_RSA_CERTIFICATE = "BEGIN RSA PRIVATE KEY";
        String END_CERTIFICATE = "END PRIVATE KEY";
        String END_RSA_CERTIFICATE = "END RSA PRIVATE KEY";
        if (StringUtils.isNotBlank(certificate)) {
            certificate = StringUtils.remove(certificate, "\r");
            certificate = StringUtils.remove(certificate, "\n");
            certificate = StringUtils.remove(certificate, "-");
            certificate = StringUtils.remove(certificate, BEGIN_CERTIFICATE);
            certificate = StringUtils.remove(certificate, BEGIN_RSA_CERTIFICATE);
            certificate = StringUtils.remove(certificate, END_CERTIFICATE);
            certificate = StringUtils.remove(certificate, END_RSA_CERTIFICATE);
            certificate = StringUtils.remove(certificate, " ");
        }
        return certificate;
    }

    public static String getPrivateKeyString(PrivateKey privateKey) {
        return Base64.encodeBase64String(privateKey.getEncoded());
    }
}
