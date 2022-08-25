package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class HomeController {
	

	
	@RequestMapping(value = "/")
	public String home() {
		return "home";
	}
	
	
	@GetMapping("/home.do")
	public String home(Model model) {
		return "hone";
	}
	
	
}
