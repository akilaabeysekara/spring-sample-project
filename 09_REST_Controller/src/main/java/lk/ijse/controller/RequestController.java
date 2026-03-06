package lk.ijse.controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/request")
@RestController
public class RequestController {
    @PostMapping
    public String post(@RequestHeader("Authorization") String authorization,
                       @RequestHeader("token") String token){
        return "Hello World! 6 "+authorization +" : Token :" + token;
    }
    @PostMapping("querystring")
    public String getQueryStringParameters(@RequestParam("name") String name,
                                           @RequestParam("address") String address,
                                           @RequestParam("id") String id){
        return "Hello World! 7" + name +" : " + address +" : " +id;
    }
    @PostMapping("pathvariable/{name}")
    public String getPathVariable(@PathVariable("name") String name){
        return "Hello World! 8 " + name;
    }
    @PostMapping("pathvariable/{name}/{address}")
    public String getPathVariables(@PathVariable("name") String name,
                                   @PathVariable("address") String address){
        return "Hello World! 8 " + name + " : " + address;
    }
    //request body - form data - not worked
    @PostMapping("body/form")
    public String getRequestBodyFormData(@RequestParam("id") String id,
                                         @RequestParam("name")  String name){
        return "Hello World! 9 " + id + " : " + name;
    }
    //request body - xwww from url encoded - done
    @PostMapping("body/form-url-encoded")
    public String getRequestBodyXWWWFormUrlEncoded(@RequestParam("id") String id,
                                                   @RequestParam("name")  String name){
        return "Hello World! 9 " + id + " : " + name;
    }
    //request body - JSON
    @PostMapping("body/json")
    public String getRequestBodyJson(){
        return "Hello World! 9 ";
    }
}
