package mit.yoni.shopping;


import java.util.ServiceConfigurationError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import domain.LoveVO;
import domain.ReviewVO;
import domain.UserVO;
import lombok.extern.log4j.Log4j;
import service.ShopService;

@Controller
@Log4j
public class WebController {

	
	@Autowired
    private ShopService service;
	
	@GetMapping("review")
	public void web() {
			
	}
	
	@GetMapping("list")
	public void list(Model model, Long bno, LoveVO vo) {
		model.addAttribute("review",service.getList());
		//model.addAttribute("review", service.love(bno));
		
	}
	
	 @PostMapping("reviewpro")
		 public String listpro(ReviewVO vo) {
			 service.register(vo);
			 return "redirect:list";
		 }
	 @GetMapping("home1")
		 public void aaa() {
			 
		 }
	
	// 조회와 수정하기 위한 화면
		@GetMapping("reviewDetail")
		public void bodify(Long bno,Model model) {
			service.get(bno);
			model.addAttribute("review",service.get(bno));
		}
		
		@GetMapping("/heart")
		public String heart(Long bno) {
		   service.lovecount(bno);
		   return "redirect:list";
		}
		@GetMapping("delete")
		public String delete(Long bno) {
			service.remove(bno);
			return "redirect:list";
		}
		@GetMapping("update")
		public String update(Long bno, Model model) {
			 model.addAttribute("review", service.get(bno));
		     return "update"; 
		}
		@PostMapping("updateReview")
		public String updateReview(ReviewVO vo) {
			service.modify(vo);
			return "redirect:list";
		}
	}
	 
	 

	

