package co.micol.prj.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.vo.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService service;
	
	@GetMapping("/noticeList.do")
	public String noticeList(Model model) {
		model.addAttribute("notices", service.noticeList());
		return "notice/noticeList";	
	}
	
	@GetMapping("/noticeForm.do")
	public String noticeForm() {
		return "notice/noticeForm";	
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, MultipartFile mFile) {
		//첨부파일 처리
		
		service.noticeInsert(vo);
		return "redirect:noticeList.do";
	}
	
	
	
	@GetMapping("/noticeSelect.do")
	public String noticeSelect(NoticeVO vo, Model model) {
		model.addAttribute("selectedNotice", service.noticeSelect(vo));
		return "notice/noticeSelect";	
	}
	
	@PostMapping("/noticeDelete.do")
	public String noticeDelete(NoticeVO vo, Model model) {
		
		int n = service.noticeDelete(vo);
		if(n !=0) {
			model.addAttribute("message", "공지글이 삭제되었습니다.");
		} else {
			model.addAttribute("message", "공지글 삭제가 실패하였습니다.");
		}
		return "notice/noticeDelete";
	}
	
	@PostMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo, Model model) {
		
		int n = service.noticeUpdate(vo);
		if(n !=0) {
			model.addAttribute("message", "공지글이 수정되었습니다.");
		} else {
			model.addAttribute("message", "공지글 수정에 실패하였습니다.");
		}
		return "notice/noticeUpdate";
	}

}
