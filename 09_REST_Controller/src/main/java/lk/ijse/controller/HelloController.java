package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("hello")
@RestController
public class HelloController {
    @GetMapping
    public String hello(){
        return "Hello World";
    }

    @PostMapping
    public String post(){
        return "Post Request";
    }

    @PutMapping
    public String put(){
        return "Put Request";
    }

    @DeleteMapping
    public String delete(){
        return "Delete Request";
    }

    @PatchMapping
    public String patch(){
        return "Patch Request";
    }


}






















































