package rcw.listener;

import java.io.IOException;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;

import rcw.utils.StaticCodeBook;

@Repository
public class SpringStartListener implements ApplicationContextAware{

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		
//		Security.addProvider(new BouncyCastleProvider());
		try {
			StaticCodeBook.initProperties();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
