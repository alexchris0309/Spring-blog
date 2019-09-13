package com.codeup.springblog.repos;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends CrudRepository <Post, Long> {

    @Query("from Post p where p.title like %:term%")
    List<Post> searchByTitleLike(@Param("term")String term);
    Iterable<Post> findByOwner(User owner);


}


