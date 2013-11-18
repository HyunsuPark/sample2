package notice.model.vo;

import java.util.Date;

public class Notice {
	private int noticeNo;
	private String noticeWriter;
	private String noticeDate;
	private String noticeTitle;
	private String noticeContent;
	
	public Notice() {
		super();
	}

	public Notice(int noticeNo, String noticeWriter, String noticeDate,
			String noticeTitle, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeWriter = noticeWriter;
		this.noticeDate = noticeDate;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeWriter() {
		return noticeWriter;
	}

	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	
	@Override
	public String toString()
	{
		return noticeNo + ", " + noticeWriter + ", " 
				+ noticeDate + ", " + noticeTitle + ", "
				+ noticeContent;
	}
}
