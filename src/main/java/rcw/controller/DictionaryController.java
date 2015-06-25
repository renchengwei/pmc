package rcw.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import rcw.pojo.Dictionary;
import rcw.service.DictionaryService;

@Controller
@RequestMapping("DictionaryController.do")
public class DictionaryController {

	@Resource(name="dictionaryService")
	private DictionaryService service;

	public DictionaryService getService() {
		return service;
	}

	public void setService(DictionaryService service) {
		this.service = service;
	}
	
	/**
	 * 根据类型查询字段信息
	 * @param request
	 * @param map
	 * @return
	 */
	@RequestMapping(params="method=getDictionaryByType")
	@ResponseBody
	public List<Dictionary> getDictionaryByType(HttpServletRequest request,@RequestParam Map<String,String> map) {
		String type = map.get("type");
		return service.getDictionaryByType(type);
	}
}
