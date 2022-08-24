package co.micol.prj.notice.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeVO {
	
	public int notice_id;
	public String notice_writer;
	public String notice_title;
	public String notice_subject;
	public Date notice_date;
	public int notice_hit;
	public String notice_attach;
	public String notice_attach_dir;
	
	

}
