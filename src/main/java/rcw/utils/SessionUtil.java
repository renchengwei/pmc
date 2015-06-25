package rcw.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import rcw.pojo.User;


public class SessionUtil {

    // 将用户信息存在session里面
    public static void setUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(StaticCodeBook.SESSION_USER, user);
//		request.getSession().setAttribute( StaticCodeBook.SESSION_USER_ID, user.getId());
//		request.getSession().setAttribute(StaticCodeBook.SESSION_USER_ORG_ID, user.getOrgid());
//		request.getSession().setAttribute(StaticCodeBook.SESSION_USER_ROLE_ID, user.getRole().getId());
//		request.getSession().setAttribute(StaticCodeBook.SESSION_LOGIN_IP,request.getRemoteAddr());
    }

    // 从session里面获取用户信息
    public static User getUser() {
    	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();    
		Object obj = request.getSession().getAttribute(StaticCodeBook.SESSION_USER);
		if (obj != null) {
		    return (User) obj;
		}
		return null;
    }
    // 从session里面获取用户信息
    public static User getUser(	HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(StaticCodeBook.SESSION_USER);
		if (obj != null) {
		    return (User) obj;
		}
		return null;
    }
    // 从session里面获取用户信息
    public static User getUser(HttpSession sess) {
		Object obj = sess.getAttribute(StaticCodeBook.SESSION_USER);
		if (obj != null) {
		    return (User) obj;
		}
		return null;
    }

    // 检查session中 用户信息 是否超时 可用
    public static boolean checkLogin(HttpServletRequest request) {
		User u = getUser();
		if (u != null) {
		    return true;
		}
		return false;
    }

    /**
     * 清空用户session
     * 
     * @param request
     */
    public static void removeUser(HttpServletRequest request) {
    	request.getSession().removeAttribute(StaticCodeBook.SESSION_USER);
    }

}
