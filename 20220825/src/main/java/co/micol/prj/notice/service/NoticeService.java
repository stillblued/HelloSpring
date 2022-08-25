package co.micol.prj.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
	
	List<Map<String, Object>> noticeList();//조인 또는 VO 객체 생성 않고 사용

	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDelete(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(String key, String val);
	
	

}
