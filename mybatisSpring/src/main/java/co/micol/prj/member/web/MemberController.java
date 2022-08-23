package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		
		model.addAttribute("members", service.memberSelectList());
		return "member/memberList";
	}
	
	@RequestMapping("/memberSelect.do")
	public String memberSelect(MemberVO vo, Model model) {
		model.addAttribute("member", service.memberSelect(vo));
		return "member/memberSelect";
	}
	
	
	@RequestMapping("/memberInsert.do")
	public String memberInsert(MemberVO vo, Model model) {
		
		int n = service.memberInsert(vo);
		if(n !=0) {
			model.addAttribute("message", "정상적으로 추가되었습니다.");
		} else {
			model.addAttribute("message", "회원 등록이 실패하였습니다.");
		}
		return "member/memberInsert";
	}
	
	@RequestMapping("/memberDelete.do")
	public String memberDelete(MemberVO vo, Model model) {
		
		int n = service.memberDelete(vo);
		if(n !=0) {
			model.addAttribute("message", "정상적으로 삭제되었습니다.");
		} else {
			model.addAttribute("message", "회원 삭제가 실패하였습니다.");
		}
		return "member/memberDelete";
	}
	
	@RequestMapping("/memberUpdate.do")
	public String memberUpdate(MemberVO vo, Model model) {
		
		int n = service.memberUpdate(vo);
		if(n !=0) {
			model.addAttribute("message", "정상적으로 변경되었습니다.");
		} else {
			model.addAttribute("message", "회원 정보 수정을 실패하였습니다.");
		}
		return "member/memberUpdate";
	}

}
