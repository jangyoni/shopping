package domain;

import java.sql.Date;

import lombok.Data;

@Data
public class ImageVO {

	private Long id;
	private String imgname;
	private Date nowtime;
	private Long joinid;
}
