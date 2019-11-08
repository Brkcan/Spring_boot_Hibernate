package com.java.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_imagecontent")
public class ImageContent {

	@Id
	private int id;

	@OneToOne
	@Column(name = "image_id")
	@MapsId
	private Image image;

	@Column(name = "t_content")
	@Lob
	private byte[] content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
