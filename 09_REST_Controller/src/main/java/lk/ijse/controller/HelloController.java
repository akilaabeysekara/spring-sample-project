package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hello")
public class HelloController {

    @PostMapping
    public String post(){
        return "Hello World! 1";
    }
    @PutMapping
    public String put(){
        return "Hello World! 2";
    }
    @PatchMapping
    public String patch(){
        return "Hello World! 3";
    }
    @GetMapping
    public String get(){
        return "Hello World! 4";
    }
    @DeleteMapping
    public String delete(){
        return "Hello World! 5";
    }



    @GetMapping("index1")
    public String index(){
        return "Hello World! 6";
    }
    @GetMapping("index2")
    public String index2(){
        return "Hello World! 7";
    }
    @GetMapping("index3")
    public String index3(){
        return "Hello World! 8";
    }
}