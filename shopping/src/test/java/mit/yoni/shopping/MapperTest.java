package mit.yoni.shopping;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import domain.ReviewVO;
import domain.UserVO;
import lombok.extern.log4j.Log4j;
import mapper.AdminMapper;
import mapper.ShopMapper;
import service.AdminService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class MapperTest {
	
	@Autowired
	ShopMapper mapper;
	

	// 글 작성하기
	@org.junit.Test
	public void testInsert() {
		ReviewVO vo = new ReviewVO();
		vo.setTitle("제발");
		vo.setContent("플리즈");
		vo.setWriter("되어라");
		mapper.insert(vo);
	}
	//글 하나 가져오기
	@Test
	public void read() {
		log.info(mapper.read(1L));
	}
	
	//글 삭제하기
	@Test
	public void delete() {
		mapper.delete(2L);
	}
	
	//글 수정하기
	@Test
	public void update() {
		ReviewVO vo = new ReviewVO();
		vo.setBno(4L);
		vo.setContent("수정되니?");
		vo.setTitle("되라");
		mapper.update(vo);
	}
	
	@Test
	public void aaa() {
		UserVO vo = new UserVO();
		vo.setId("ss");
		UserVO vo2=mapper.signin(vo);
		log.error(vo2);
	}
	@Test
	public void list() {
		mapper.getList().forEach(x->log.info(x));
	}

	@Test
	public void love() {
		mapper.lovecount(7L);
	}
	
}
