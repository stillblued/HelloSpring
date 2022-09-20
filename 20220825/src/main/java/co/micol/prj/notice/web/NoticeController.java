package co.micol.prj.notice.web;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import co.micol.prj.notice.service.NoticeService;
import co.micol.prj.notice.service.NoticeVO;

@Controller
public class NoticeController {
	@Autowired
	private NoticeService ns;
	@Autowired
	private ServletContext servletContext;
	
	
	@PostMapping("/noticeSelect.do")
	public String noticeSelect(Model model, NoticeVO vo, HttpServletRequest req) {
		
		ns.noticeHitUpdate(vo);
		model.addAttribute("n", ns.noticeSelect(vo));
		return "notice/noticeSelect";
	}
	
	
	@GetMapping("/noticeList.do")
	public String noticeList(Model model, Principal principal, @AuthenticationPrincipal UserDetails user) {
		
		System.out.println(principal.getName());
		model.addAttribute("notices", ns.noticeList());
		return "notice/noticeList";
	}
	
	@PostMapping("/noticeInsert.do")
	public String noticeInsert(NoticeVO vo, @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {
		String saveFolder = servletContext.getRealPath("/fileUpload"); //저장공간폴더명
		File sfile = new File(saveFolder); //물리저장위치
		String ofileName = file.getOriginalFilename();//넘어온파일이름
		
		if(!ofileName.isEmpty()) {
		//파일명 충돌 방지를 위한 파일 별칭
		String sfileName = UUID.randomUUID().toString() + ofileName.substring(ofileName.lastIndexOf("."));
		file.transferTo(new File(sfile, sfileName)); //저장
		vo.setNoticeAttach(ofileName);
		vo.setNoticeAttachDir(saveFolder + File.separator +sfileName);
		};
		
		ns.noticeInsert(vo);
		
		return "redirect:noticeList.do";
	}
	
	
	@GetMapping("/noticeForm.do")
	public String noticeForm() {
		
		return "notice/noticeForm";

	}
	
	@GetMapping("/noticeUpForm.do")
	public String noticeUpForm() {
		
		return "notice/noticeUpdate";
	}
	
	
	@RequestMapping("/noticeUpdate.do")
	public String noticeUpdate(NoticeVO vo) {
		vo.setNoticeWriter("운영자");
		vo.setNoticeId(26);
		ns.noticeUpdate(vo);
		
		return "redirect:noticeList.do";
	}
	
	
	@RequestMapping("/noticeSearch.do")
	public String noticeSearch(@Param(value = "key") String key, @Param(value = "val")String val, Model model) { 
		
		model.addAttribute("notices", ns.noticeSearch(key, val));
		return "notice/noticeSearch";
	}
	

	@RequestMapping(value = "/ajaxNoticeSelect.do", produces = "application/text; charset=utf8")
	@ResponseBody
	public String ajaxNoticeSelect(HttpServletResponse res) {
		
		return "ajax Test해봄 ㅇㅅㅇ~";
	}
	
	@GetMapping("/ajaxTest.do")
	public String ajaxTest() {
		return "notice/ajaxTest";
	}
	
	
	
	
	
	
}
