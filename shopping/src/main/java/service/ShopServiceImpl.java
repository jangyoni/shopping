package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.LoveVO;
import domain.ReviewVO;
import domain.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import mapper.ShopMapper;

@Service
@AllArgsConstructor
@Log4j
public class ShopServiceImpl implements ShopService {

	private ShopMapper mapper; //생성자 주입
	
	@Override
	public void register(ReviewVO vo) {
		
		log.info("글을등록한다"+vo);
		mapper.insert(vo);

	}

	@Override
	public ReviewVO get(Long bno) { 
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(ReviewVO vo) {
		
		return mapper.update(vo)==1 ? true:false;
	}

	@Override
	public boolean remove(Long bno) {
		
		return mapper.delete(bno)==1 ? true:false;
	}


	@Override
	public UserVO signin(UserVO vo) {
		
		return mapper.signin(vo);
	}

	@Override
	public List<ReviewVO> getList() {
		
		return mapper.getList();
	}

	@Override
	public int signup(UserVO vo) {
		
		return mapper.signup(vo);
	}

	@Override
	public void viewview(long bno) {
		
		mapper.read(bno);
		
	}

	@Override
	public void lovecount(Long bno) {
		mapper.lovecount(bno);
		
	}

	
	}

	

	
	




