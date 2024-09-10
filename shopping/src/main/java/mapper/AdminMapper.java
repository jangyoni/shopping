package mapper;


import java.util.List;
import java.util.Map;

import domain.ProductVO;
import domain.ReviewVO;
import domain.UserVO;

public interface AdminMapper {

		//상품등록
		Long productInsert(ProductVO vo);
	
		//상품조회(한행보기)
		ProductVO proread(Long id);
		
		//상품삭제(한행삭제)
		int prodelete(Long id);
		
		//상품수정(한행수정)
		int proupdate(ProductVO vo);
	
		//상품 목록보기
		List<ProductVO> progetList();
		
		//검색구현
		List<ProductVO> searchProducts(Map<String, Object> params);
		
		
}

