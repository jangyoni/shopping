package mit.yoni.shopping;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import domain.ImageVO;
import domain.ProductVO;
import lombok.extern.log4j.Log4j;
import service.AdminService;
import service.ImageService;

@Log4j
@Controller
@RequestMapping("/admin/*")
public class AdminController {
	
    private String uploadPath="c:/upload";

    @Autowired
    private AdminService service;

    @Autowired
    private ImageService imageService;

    // 관리자 화면
    @RequestMapping("index")
    public void getIndex() {        
    
    }
    
    @GetMapping("product")
    public void insert(ProductVO vo) {
        
    }
    @PostMapping("prolist")
    public String aaa(ProductVO vo,  MultipartFile[] uploadfile) {
    	service.productInsert(vo);
    	
    	long id =vo.getId();
     
    	log.info("아이디 : "+ id);
    	
    	String uploadFolder = "c:\\upload";
        
        

        if (uploadfile == null) {
            log.error("No files uploaded");
            return "redirect:prolist";
        }

        for (MultipartFile multipartFile : uploadfile) {
            if (multipartFile.isEmpty()) {
                log.warn("Uploaded file is empty: " + multipartFile.getOriginalFilename());
                
                continue;
            }

            log.info("사진이름: " + multipartFile.getOriginalFilename());
            log.info("사진크기: " + multipartFile.getSize());

            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            try {
                multipartFile.transferTo(saveFile);
                ImageVO ivo = new ImageVO();
                ivo.setImgname(multipartFile.getOriginalFilename());
                ivo.setJoinid(id);
                imageService.insertImage(ivo);
                log.info("File saved: " + saveFile.getAbsolutePath());
            } catch (Exception e) {
                log.error("Error saving file: " + multipartFile.getOriginalFilename(), e);
            }
        }
    

        return "redirect:prolist";
    }
    
    @PostMapping("product")
    public String listpro(ProductVO vo) {
        return "redirect:prolist";
    }
    
    @GetMapping("prolist")
    public void list(Model model, ProductVO vo) {
        model.addAttribute("list", service.progetList());
    }
    
    @PostMapping("/uploadProductAction")
    public String uploadProductAction(@RequestParam("uploadfile") MultipartFile[] uploadfile,
                                      @RequestParam("name") String name,
                                      @RequestParam("protitle") String protitle,
                                      @RequestParam("description") String description,
                                      @RequestParam("price") int price,
                                      Model model) {
        // 상품 정보 저장 로직
        ProductVO product = new ProductVO();
        product.setName(name);
        product.setProtitle(protitle);
        product.setDescription(description);
        product.setPrice(price);

        // 상품 정보를 저장하는 서비스 메서드 호출
        service.productInsert(product);
        Long joinId = product.getId(); // 저장된 상품의 ID를 가져옴

        for (MultipartFile multipartFile : uploadfile) {
            if (multipartFile.isEmpty()) {
                log.warn("Uploaded file is empty: " + multipartFile.getOriginalFilename());
                continue;
            }

            try {
                imageService.saveImage(multipartFile, joinId);
                model.addAttribute("message", "File uploaded successfully: " + multipartFile.getOriginalFilename());
            } catch (Exception e) {
                log.error("Error saving file: " + multipartFile.getOriginalFilename(), e);
                model.addAttribute("message", "File upload failed: " + e.getMessage());
            }
        }

        return "redirect:/admin/productDetail?id=" + joinId;
    }
    
    @GetMapping("productDetail")
    public void detail(Long id, Model model) {
    	
        List<ImageVO> images = imageService.findByJoinId(id);
        
        model.addAttribute("list", service.proread(id));
        model.addAttribute("images", images);
    }
    
    @GetMapping("delete")
	public String delete(Long id) {
		service.prodelete(id);
		return "redirect:prolist";
	}
    
    @GetMapping("proUpdate")
    public void update(Model model, Long id) {
       
        model.addAttribute("product", service.proread(id));
        model.addAttribute("images", imageService.findByJoinId(id));
    }

    @PostMapping("proUpdate")
    public String update(ProductVO vo, MultipartFile[] uploadfile) {
        // 기존 상품 정보 업데이트
        service.proupdate(vo);
        
        // 새로운 이미지 저장 로직 추가
        String uploadFolder = "c:\\upload";

        for (MultipartFile multipartFile : uploadfile) {
            if (multipartFile.isEmpty()) {
                log.warn("Uploaded file is empty: " + multipartFile.getOriginalFilename());
                continue;
            }

            log.info("사진이름: " + multipartFile.getOriginalFilename());
            log.info("사진크기: " + multipartFile.getSize());

            File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());

            try {
                // 기존 파일이 존재하면 덮어씁니다.
                multipartFile.transferTo(saveFile);
                ImageVO ivo = new ImageVO();
                ivo.setImgname(multipartFile.getOriginalFilename());
                ivo.setJoinid(vo.getId());
                imageService.insertImage(ivo);
                log.info("File saved: " + saveFile.getAbsolutePath());
            } catch (Exception e) {
                log.error("Error saving file: " + multipartFile.getOriginalFilename(), e);
            }
        }

        return "redirect:prolist";
    }
    
    @PostMapping("deleteImage")
    @ResponseBody
    public String deleteImage(@RequestParam("imageId") Long imageId) {
        // 이미지 삭제 로직
        ImageVO image = imageService.findImageById(imageId); // findImageById로 변경
        if (image != null) {
            File file = new File("c:/upload/" + image.getImgname());
            if (file.exists()) {
                file.delete();
            }
            imageService.deleteImage(imageId);
        }
        return "success";
    }
    }

