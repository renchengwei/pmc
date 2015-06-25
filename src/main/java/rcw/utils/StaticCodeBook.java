package rcw.utils;

import java.io.IOException;
import java.util.ResourceBundle;

public class StaticCodeBook {
	
	public static final String ISDEL_YES = "1";
	public static final String ISDEL_NO = "0";
	
	public static final String SESSION_USER = "SESSION_USER";

	
	private static ResourceBundle bundle;
	
	public static void initProperties() throws IOException {
		bundle = ResourceBundle.getBundle("config/config");
		
//		StringBuilder configpath = new StringBuilder(System.getProperty("Demo.root"));
//		configpath.append("WEB-INF").append(File.separatorChar).append("config").append(File.separatorChar).append("config.properties");
//		InputStream in = null;
//		try {
//			in = new FileInputStream(configpath.toString());
//			properties.load(in);
//		} finally {
//			if(in != null) {
//				in.close();
//			}
//		}
	}
	
	public static String getPropertie(String key) {
		return bundle.getString(key);
	}
	
	//分页使用的常量
	public static String PAGE_TOTAL="total";
	public static String PAGE_ROWS="rows";
	public static String PAGE_NO="page";
	
	//jsp页面
	public static String  LOGIN_PAGE="login.jsp";
		
}
