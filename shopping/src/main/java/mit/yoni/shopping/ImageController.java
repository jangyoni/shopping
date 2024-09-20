package mit.yoni.shopping;

import domain.ReviewVO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.AdminService;
import service.ImageService;

@Log4j
@Controller
@RequestMapping("/")
public class ImageController {

    private  String imagePath="c:/image";


    @PostMapping("reviewDatail")
    public String reviewDatail(ReviewVO vo, MultipartFile[] uploadFile){

        return "redirect:/reviewDatail";
    }

}
