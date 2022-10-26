package jweb.p.a101.model;

import java.sql.Date;
import java.time.LocalDate;

public class Content {

	private int id, authorId;
	private String title, brief,content, sort;
	private LocalDate createDate, updateTime;
	public LocalDate getCreateDate() {
		return createDate;
	}


	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}


	/**
	 * @param id
	 * @param title
	 * @param brief
	 * @param content
	 * @param createDate
	 */
	public Content(int id, String title, String brief, String content, LocalDate createDate) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.createDate = createDate;
	}


	public Content(int id, int authorId, String title, String brief, String content, String sort, LocalDate createDate,
			LocalDate updateTime) {
		this.id = id;
		this.authorId = authorId;
		this.title = title;
		this.brief = brief;
		this.content = content;
		this.sort = sort;
		this.createDate = createDate;
		this.updateTime = updateTime;
	}

	public Content(int id, String title, String brief, String content) {
		this.id = id;
		this.title = title;
		this.brief = brief;
		this.content = content;
	}

	public Content() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBrief() {
		return brief;
	}
	public void setBrief(String brief) {
		this.brief = brief;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public LocalDate getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}


	@Override
	public String toString() {
		return "Content [id=" + id + ", authorId=" + authorId + ", title=" + title + ", brief=" + brief + ", content="
				+ content + ", sort=" + sort + ", createDate=" + createDate + ", updateTime=" + updateTime + "]";
	}
	
}
