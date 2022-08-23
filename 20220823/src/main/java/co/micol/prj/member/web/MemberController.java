package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.memberService.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService dao;
	
	@RequestMapping("/memberList.do")
	public String memberList(Model model) {
		model.addAttribute("members", dao.memberSelectList());
		return "member/memberList";
	}
	
	
}
