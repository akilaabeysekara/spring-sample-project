package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

//    @PostMapping("/detail")
//    public String saveCustomer1(){
//        return "Customer Save 1";
//    }

    @PostMapping("/detail")
    public String saveCustomer(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("address") String address){
                return "saved-2 " + name + " " + id + " " + address + " ";
    }

    //Query String Parameter
    @GetMapping("/search")
    public String searchCustomer(@RequestParam("id") String id){return "search-3: "+ id;
    }

    //Path Variable Parameter
    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable("id") String cid){return "delete-4: "+ cid;
    }

}
