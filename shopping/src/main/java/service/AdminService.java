package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.ProductVO;
import domain.ReviewVO;

@Service
public interface AdminService {

	//상품등록
	Long productInsert(ProductVO vo);

	//상품조회(한행보기)
	ProductVO proread(Long id);
	
	//상품삭제(한행삭제)
	 boolean prodelete(Long id);
	
	//상품수정(한행수정)
	 boolean proupdate(ProductVO vo);

	//상품 목록보기
	List<ProductVO> progetList();
	

}
