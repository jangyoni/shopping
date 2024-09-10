package domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ReviewVO {
	
	private Long bno;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int luv;
	private int viewview;
	

}
