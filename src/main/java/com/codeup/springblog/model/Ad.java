package com.codeup.springblog.model;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="Ads")
public class Ad {
    @Id @GeneratedValue
    private long id;

    @OneToOne
    private User user;

}
