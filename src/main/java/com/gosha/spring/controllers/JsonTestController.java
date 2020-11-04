package com.gosha.spring.controllers;

import com.gosha.spring.models.Post;
import com.gosha.spring.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class JsonTestController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/json_test")
    public List<Post> json_test(@RequestParam(value = "id",defaultValue ="") String param_id,@RequestParam(value = "insert",defaultValue ="0") String insert){
        long id=0;
        int count=0;

        try {
            id=Long.parseLong(param_id);
        }catch (Exception e){

        }


        try {
            count=Integer.parseInt(insert);
        }catch (Exception e){

        }
        ArrayList<Post> res=new ArrayList<>();

        if (count>0){
            int i=0;
            String title,anons,text;
            while (i<=count){
                i++;

                title="title"+i;
                anons="anons"+i;
                text="text"+i;
                postRepository.save(new Post(title,anons,text));

            }
        }else {

            if (id==0){
                Iterable<Post> post =postRepository.findAll();
                post.forEach(res::add);
            }else {
                Optional<Post> post =postRepository.findById(id);
                post.ifPresent(res::add);
            }
        }

        return  res;
    }


}
