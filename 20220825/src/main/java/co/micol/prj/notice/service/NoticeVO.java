package co.micol.prj.notice.service;

import java.sql.Date;
import lombok.Data;

@Data
public class NoticeVO {
	
	public int noticeId;
	public String noticeWriter;
	public String noticeTitle;
	public String noticeSubject;
	public Date noticeDate;
	public int noticeHit;
	public String noticeAttach;
	public String noticeAttachDir;

}
