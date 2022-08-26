package co.micol.prj.notice.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeVO {
	
	public int noticeId;
	public String noticeWriter;
	public String noticeTitle;
	public String noticeSubject;
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	public Date noticeDate;
	public int noticeHit;
	public String noticeAttach;
	public String noticeAttachDir;

}
