package co.micol.prj.notice.map;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import co.micol.prj.notice.service.NoticeVO;

public interface NoticeMapper {
	
	@Select ("select * from notice")
	List<Map<String, Object>> noticeList();
	
	NoticeVO noticeSelect(NoticeVO vo);
	
	int noticeInsert(NoticeVO vo);
	
	int noticeUpdate(NoticeVO vo);
	
	int noticeDelete(NoticeVO vo);

	int noticeHitUpdate(NoticeVO vo);
	
	List<NoticeVO> noticeSearch(@Param(value = "key") String key, @Param(value = "val")String val);
	//mapper 매개변수 두개 이상일 시 @Param
	
	
}
