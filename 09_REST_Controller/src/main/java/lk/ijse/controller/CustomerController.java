package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

//    @PostMapping("/save")
//    public String saveCustomer1(){
//        return "Customer Save 1";
//    }

    //URL embedded - path variable, query params
    //header - key : value
    //body - x-www-form-urlencoded, json, formdata, xml...


    @PostMapping("/save")
    public String saveCustomer(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("address") String address){
                return "saved-2 " + name + " " + id + " " + address + " ";
    }

    //PUT mapping - Update entire customer resource using request parameters
    @PutMapping("/update")
    public String updateCustomer(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("address") String address) {
        return "updated-3 " + name + " " + id + " " + address + " ";
    }

    //PATCH mapping - Partial update using path variable and request parameter
    @PatchMapping("/{id}")
    public String partialUpdateCustomer(
            @PathVariable("id") String id,
            @RequestParam("address") String address) {
        return "partial-update-4: " + id + " address: " + address;
    }

    //Query String Parameter
    @GetMapping("/search")
    public String searchCustomer(@RequestParam("id") String id){return "search-5: "+ id;
    }

    //Path Variable Parameter
    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable("id") String cid){return "delete-6: "+ cid;
    }

}
