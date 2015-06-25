package rcw;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import rcw.pojo.User;
import rcw.service.UserService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class TestSpring  extends AbstractJUnit4SpringContextTests{

	@Test
	public void test1() {
		UserService service = (UserService) applicationContext.getBean("userService");
	}
	
	public void test2() {
		UserService service = (UserService) applicationContext.getBean("userService");
	}
	@Test
	public void saveUser() {
		UserService service = (UserService) applicationContext.getBean("userService");
		User user = new User();
//		user.setLoginName("loginname");
//		user.setRealName("realname");
		user.setPassword("aa");
	}
}
