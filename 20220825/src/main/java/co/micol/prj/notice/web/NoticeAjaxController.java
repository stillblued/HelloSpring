package co.micol.prj.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;

@RestController
public class NoticeAjaxController {
	@Autowired
	private NoticeService ajaxDao;
	
	@PostMapping("/ajaxSearch.do")
	public List<NoticeVO> ajaxSearch(@RequestParam String key, @RequestParam String val){
		return ajaxDao.noticeSearch(key, val);
	}
	
}
