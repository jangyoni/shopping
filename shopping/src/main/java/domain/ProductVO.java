package domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class ProductVO {

	private Long id;
	private String name;
	private String protitle;
	private String description;
	private int price;
	private Date created_at;
	private List<ImageVO> images;
}
