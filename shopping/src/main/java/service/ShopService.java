package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.LoveVO;
import domain.ReviewVO;
import domain.UserVO;

@Service
public interface ShopService {

	//서비스(비지니스 로직) -즉, 사용자관점에서 단위
		//1. 게시글 등록
		 void register(ReviewVO vo);
		//2. 게시글 읽기
		 ReviewVO get(Long bno);
		//3. 게시글 수정
		 boolean modify(ReviewVO vo);
		//4. 게시글 삭제
		 boolean remove(Long bno);
		//5. 좋아요구현
		 void lovecount(Long bno);
		 // user id로 찾기
		 UserVO signin(UserVO vo);
		 
		 int signup(UserVO vo);
		// 글쓴거 목록보기
		List<ReviewVO> getList();
		
		void viewview(long bno);
		
		 
		
}
