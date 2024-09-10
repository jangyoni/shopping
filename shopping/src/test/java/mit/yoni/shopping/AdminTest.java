package mit.yoni.shopping;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import domain.ImageVO;
import domain.ReviewVO;
import lombok.extern.log4j.Log4j;
import service.AdminService;
import service.ImageService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class AdminTest {
	
	@Autowired
	AdminService service;
	
	@Autowired
	ImageService imgservice;
	
	@Test
	public void aaa() {
		
	}
	
	@Test
	public void aaaa() {
	ImageVO vo = new ImageVO();
	vo.setImgname("되나");
	vo.setJoinid(5L);
	imgservice.insertImage(vo);
}
	
	

}
