package co.micol.prj.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.micol.prj.notice.map.NoticeMapper;
import co.micol.prj.notice.vo.NoticeVO;


@Service
public class NoticeServiceImpl implements NoticeService{
	@Autowired
	private NoticeMapper map;

	@Override
	public List<NoticeVO> noticeList() {
		return map.noticeList();
	}

	@Override
	public NoticeVO noticeSelect(NoticeVO vo) {
		return map.noticeSelect(vo);
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		return map.noticeInsert(vo);
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		return map.noticeUpdate(vo);
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		return map.noticeDelete(vo);
	}

}
