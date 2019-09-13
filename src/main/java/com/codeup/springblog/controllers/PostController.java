package com.codeup.springblog.controllers;

import com.codeup.springblog.model.Post;
import com.codeup.springblog.model.User;
import com.codeup.springblog.repos.PostRepository;
import com.codeup.springblog.repos.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;




@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postRepository, UserRepository userRepository){
        this.postDao=postRepository;
        this.userDao=userRepository;
    }

    @Autowired
    private EmailService emailService;


    @GetMapping("/post")
    public String post(Model vModel) {
        Iterable <Post> posts=postDao.findAll();

        vModel.addAttribute("posts",posts);
        return "post/index";
    }

    @RequestMapping(path = "/post/{n}", method = RequestMethod.GET)
    public String individualPost(@PathVariable long n, Model vModel) {
        Post postbyId =postDao.findOne(n);
        vModel.addAttribute("post", postbyId);


       return "post/show";
    }


    @RequestMapping(path = "/post/{n}/delete", method = RequestMethod.POST)
    public String deletePost(@PathVariable long n) {
        postDao.delete(n);

        return "redirect:/post";
    }


    @RequestMapping(path="/post/{id}/edit", method= RequestMethod.GET)
    public String editPostForm(@PathVariable long id, Model vModel){
        Post post=postDao.findOne(id);
        vModel.addAttribute("post",post);
        return "post/edit";
        }


    @RequestMapping(path = "/post/{id}/edit", method = RequestMethod.POST)
    public String editPost(@PathVariable long id, @ModelAttribute Post post){
        postDao.save(post);
        return "redirect:/post";
    }





    @GetMapping("/post/create")
    public String createPostForm(Model vModel) {
        vModel.addAttribute("post", new Post());
        return "post/create";
    }

    @PostMapping("/post/create")
    public String createPost( @ModelAttribute Post post){
        User userSession=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userdb =userDao.findOne(userSession.getId());
        post.setOwner(userdb);
        Post savedPost=postDao.save(post);

        emailService.prepareAndSend(
                savedPost,
                "Post Created",
                String.format("Post with the id %d has been created",savedPost.getId()));
        return "redirect:/post";
    }





}
