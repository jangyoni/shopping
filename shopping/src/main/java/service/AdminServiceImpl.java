package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.ProductVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import mapper.AdminMapper;
import mapper.ShopMapper;

@Service
@AllArgsConstructor
@Log4j
public class AdminServiceImpl implements AdminService {

	
	private AdminMapper mapper; //생성자 주입

	@Override
	public Long productInsert(ProductVO vo) {
		
		return mapper.productInsert(vo);
		
	}

	@Override
	public ProductVO proread(Long id) {
		
		return mapper.proread(id);
	}


	
	@Override
	public List<ProductVO> progetList() {
		
		return mapper.progetList();
	}

	@Override
	public boolean prodelete(Long id) {
		
		return mapper.prodelete(id)==1 ? true:false;
	}

	@Override
	public boolean proupdate(ProductVO vo) {
		
		return mapper.proupdate(vo)==1? true:false;
	}
	
	
	}


