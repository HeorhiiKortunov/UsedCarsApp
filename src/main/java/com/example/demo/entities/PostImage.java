package com.example.demo.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "post_images")
@NamedQuery(
        name = "PostImage.getById",
        query = "SELECT p FROM PostImage p WHERE p.id = :id"
)
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id")
    private Posts post;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image_data;

    public PostImage() {}

    public PostImage(Long id, Posts post, byte[] image_data) {
        this.id = id;
        this.post = post;
        this.image_data = image_data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Posts getPost() {
        return post;
    }

    public void setPost(Posts post) {
        this.post = post;
    }

    public byte[] getImage_data() {
        return image_data;
    }

    public void setImage_data(byte[] image_data) {
        this.image_data = image_data;
    }
}