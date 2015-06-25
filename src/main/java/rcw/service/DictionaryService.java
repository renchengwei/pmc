package rcw.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import rcw.dao.DictionaryDao;
import rcw.pojo.Dictionary;

@Component("dictionaryService")
public class DictionaryService {

	@Resource(name="dictionaryDao")
	private DictionaryDao dao;

	public DictionaryDao getDao() {
		return dao;
	}

	public void setDao(DictionaryDao dao) {
		this.dao = dao;
	}

	public List<Dictionary> getDictionaryByType(String type) {
		return dao.getDictionaryByType(type);
	}
	
}
