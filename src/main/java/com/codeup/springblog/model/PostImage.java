package com.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {
    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String path;

    @ManyToOne
    @JoinColumn (name = "post_id")
    private Post post;

    public PostImage(){};

    public PostImage(long id, String path, Post post){
        this.id=id;
        this.path=path;
        this.post=post;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }


}