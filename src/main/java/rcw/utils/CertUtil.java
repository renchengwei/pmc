package rcw.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.x500.X500Principal;

import org.apache.commons.lang.StringUtils;


public class CertUtil {

	public static Map<String, String> getSubjectX500Principal(X509Certificate cert) {
		Map<String, String> ret = new HashMap<String, String>();
		X500Principal x500Principal = cert.getSubjectX500Principal();
		String name = x500Principal.getName();
		if(StringUtils.isNotEmpty(name)) {
			String[] namearr = name.split(",");
			for(String s : namearr) {
				String[] keyvalue = s.split("=");
				ret.put(keyvalue[0], keyvalue[1]);
			}
		}
		return ret;
	}
	
	public static X509Certificate getX509CertificateFromBase64(String base64cert) throws CertificateException, NoSuchProviderException {
		base64cert = base64cert.replace("-----BEGIN CERTIFICATE-----", "").replace("-----END CERTIFICATE-----", "");
		byte[] data = EncryptUtils.byte64DecodeToString(base64cert);
		InputStream fin = new ByteArrayInputStream(data);
		CertificateFactory f = CertificateFactory.getInstance("X.509","BC");
		X509Certificate certificate = (X509Certificate) f.generateCertificate(fin);
		return certificate;
	}
	
	public static X509Certificate getX509CertificateFromInputStream(InputStream inputStream) throws CertificateException, NoSuchProviderException {
		CertificateFactory f = CertificateFactory.getInstance("X.509","BC");
		X509Certificate certificate = (X509Certificate) f.generateCertificate(inputStream);
		return certificate;
	}
	
	public static String getBase64ForX509Certificate(X509Certificate cert) throws CertificateEncodingException {
		String certbase64 = EncryptUtils.byte64EncodeToString(cert.getEncoded());
		String line =  System.getProperty("line.separator");
		certbase64 = certbase64.replace(line, "");
		return certbase64;
	}
}
