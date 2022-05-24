package com.example.demo.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(	name = "series")
public class Series {
	
	@Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="title",length = 250)
	private String title;
	
	
	@Column(name="image")
	private String image;
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Column(name="bgvideo")
	private String bgvideo;
	
	@Column(name="watch_now")
	private String watch_now;
	
	@OneToMany(fetch = FetchType.LAZY,
	          cascade = {
	              CascadeType.PERSIST,
	              CascadeType.MERGE
	          },
	          mappedBy = "episodes")

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBgvideo() {
		return bgvideo;
	}

	public void setBgvideo(String bgvideo) {
		this.bgvideo = bgvideo;
	}

	public String getWatch_now() {
		return watch_now;
	}

	public void setWatch_now(String watch_now) {
		this.watch_now = watch_now;
	}

	public int getNo_episodes() {
		return no_episodes;
	}

	public void setNo_episodes(int no_episodes) {
		this.no_episodes = no_episodes;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOngoing_process() {
		return ongoing_process;
	}

	public void setOngoing_process(String ongoing_process) {
		this.ongoing_process = ongoing_process;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreatedby() {
		return createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name="no_episodes",length = 250)
	private int no_episodes;
	
	@Column(name="date",length = 250)
	private String date;
	
	@Column(name="status")
	private int status = 0;
	
	@Column(name="ongoing_process",length = 250)
	private String ongoing_process;
	
	@Column(name="description",length = 2000)
	private String description;
	
	@Column(name="craetedby",length = 250)
	private String createdby = "admin";
	
	

	
	
	
	
	
	
	

}
