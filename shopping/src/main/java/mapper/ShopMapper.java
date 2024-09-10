package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import domain.LoveVO;
import domain.ReviewVO;
import domain.UserVO;

public interface ShopMapper {


	//글등록(한행추가)
	void insert(ReviewVO vo);
	//글조회(한행보기)
	ReviewVO read(Long bno);
	//글삭제(한행삭제)
	int delete(Long bno);
	//글수정(한행수정)
	int update(ReviewVO vo);
	//글좋아요
	void lovecount(Long bno);
    // 회원 정보 확인 및 추가
	UserVO signin(UserVO vo);
	// 로그인
	int signup(UserVO vo);
	// 글쓴거 목록보기
	List<ReviewVO> getList();
  
}


