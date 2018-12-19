package maple.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String say(Model model) {
		model.addAttribute("name", "maple");
		model.addAttribute("url", "https://www.maple007.top");
		
		return "hello";
	}
}
