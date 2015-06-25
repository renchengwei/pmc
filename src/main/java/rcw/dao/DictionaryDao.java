package rcw.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import rcw.pojo.Dictionary;

@Component("dictionaryDao")
public class DictionaryDao extends BaseDao{

	public List<Dictionary> getDictionaryByType(String type) {
		String hql = "from Dictionary where type=?";
		List<Object> params = new ArrayList<Object>();
		params.add(type);
		List<Dictionary> list = this.queryByHql(hql, params);
		return list;
	}

	
}
