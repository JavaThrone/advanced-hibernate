package org.it.discovery.training.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class Hit extends BaseEntity{
	private String ip;
	
	private String browser;
	
	private LocalDateTime viewed;

	@ManyToOne
	@JoinColumn(name = "BOOK_ID")
	private Book book;
	
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public LocalDateTime getViewed() {
		return viewed;
	}

	public void setViewed(LocalDateTime viewed) {
		this.viewed = viewed;
	}	

}
