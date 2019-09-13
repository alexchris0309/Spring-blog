package com.codeup.springblog.model;
import javax.persistence.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name="posts")

public class Post {
    @Id @GeneratedValue
    private long id;

    @Column (nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition ="TEXT")
    private String body;

    @OneToOne
    private User owner;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<PostImage> images;


    public Post(){}



    public Post(long id , String title, String body, User owner,List<PostImage> images) {
        this.id = id;
        this.body = body;
        this.title = title;
        this.owner=owner;
        this.images=images;

    }

    public List<PostImage> getImages() {
        return images;
    }

    public void setImages(List<PostImage> images) {
        this.images = images;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}








