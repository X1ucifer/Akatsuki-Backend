package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(	name = "videos")
public class Videos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long videoid;
	
	
	
	
	@OneToMany(fetch = FetchType.LAZY,
	          cascade = {
	              CascadeType.PERSIST,
	              CascadeType.MERGE
	          })
	    @JoinTable(name = "episodes",
	          joinColumns = { @JoinColumn(name = "video_id") },
	          inverseJoinColumns = { @JoinColumn(name = "series_id") })
	  private Set<Series> episodes = new HashSet<>();

	
	public Set<Series> getEpisodes() {
		return episodes;
	}

	public void setEpisodes(Set<Series> episodes) {
		this.episodes = episodes;
	}

	public Long getVideoid() {
		return videoid;
	}

	public void setVideoid(Long videoid) {
		this.videoid = videoid;
	}


	@Column(name="title",length = 250)
	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	@Column(name="video",length = 250)
	private String video;
	
	@Column(name="status")
	private int status = 0;

	public Long getId() {
		return videoid;
	}

	public void setId(Long id) {
		this.videoid = id;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	

}
