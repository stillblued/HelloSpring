package co.micol.prj.member.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	
	@GetMapping("memberLoginForm.do")
	public String memberLoginForm() {

		return "notiles/member/memberLoginForm";
	}
	
	@GetMapping("memberJoinForm.do")
	public String memberJoinForm() {

		return "notiles/member/memberJoinForm";
	}
	
	

}
