package vn.DuyHao.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")

@NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CategoryId")
	private int categoryId;
	@Column(name = "Categorycode")
	private String categorycode;
	@Column(name = "Categoryname")
	private String categoryname;
	@Column(name = "Images")
	private String images;
	@Column(name = "Status")
	private boolean status;
	// bi-directional many-to-one association to Video
	@OneToMany(mappedBy = "category")

	private List<Video> videos;

	public Category() {

	}

	public int getCategoryId() {

		return this.categoryId;

	}

	public void setCategoryId(int categoryId) {

		this.categoryId = categoryId;

	}

	public String getCategorycode() {

		return categorycode;

	}

	public void setCategorycode(String categorycode) {

		this.categorycode = categorycode;

	}

	public String getCategoryname() {

		return categoryname;

	}

	public void setCategoryname(String categoryname) {

		this.categoryname = categoryname;

	}

	public String getImages() {

		return images;

	}

	public void setImages(String images) {

		this.images = images;

	}

	public boolean isStatus() {

		return status;

	}

	public void setStatus(boolean status) {

		this.status = status;

	}

	public List<Video> getVideos() {

		return this.videos;

	}

	public void setVideos(List<Video> videos) {

		this.videos = videos;

	}

	public Video addVideo(Video video) {

		getVideos().add(video);

		video.setCategory(this);

		return video;
	}

	public Video removeVideo(Video video) {

		getVideos().remove(video);

		video.setCategory(null);

		return video;

	}
	

}
