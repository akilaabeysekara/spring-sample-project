package lk.ijse.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    //URL embedded - path variable, query params
    //header - key : value
    //body - x-www-form-urlencoded, json, formdata, xml...

    //------------------------------------------------------------------------------------------------------------

//POST mapping - Save entire customer resource using request parameters
    @PostMapping("/save1")
    public String saveCustomerRequestParams(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("address") String address){
        return "saved-1 using query params " + id + " " + name + " " + address;
    }

    //POST mapping - Save entire customer resource using x-www-form-urlencoded in request body
    //In modern REST APIs, we normally use JSON instead of x-www-form-urlencoded in request body
    @PostMapping("/save2")
    public String saveCustomerBodyXWWWFormUrlEncoded( // request body is like this id=C001&name=Akila&address=Galle
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address) {
        return "saved-2 using x-www-form-urlencoded  " + id + " " + name + " " + address;
    }

    //POST mapping - Save entire customer resource using form data in request body
    //In modern REST APIs, we normally use JSON instead of form-data
    @PostMapping(value="/save3", consumes="multipart/form-data") //explicitly declare the content type of the request body
    public String saveCustomerBodyFormData( // request body is unlike id=C001&name=Akila&address=Galle so need to declare content type
                                            @RequestParam String id,
                                            @RequestParam String name,
                                            @RequestParam String address) {
        return "saved-3 using form-data " + id + " " + name + " " + address;
    }


    //PUT mapping - Update entire customer resource using request parameters
    @PutMapping("/update")
    public String updateCustomer(
            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("address") String address) {
        return "updated-4 " + name + " " + id + " " + address + " ";
    }

    //PATCH mapping - Partial update using path variable and request parameter
    @PatchMapping("/{id}")
    public String partialUpdateCustomer(
            @PathVariable("id") String id,
            @RequestParam("address") String address) {
        return "partial-update-5: " + id + " address: " + address;
    }

    //Query String Parameter
    @GetMapping("/search")
    public String searchCustomer(@RequestParam("id") String id){return "search-6: "+ id;
    }

    //Path Variable Parameter
    @DeleteMapping("{id}")
    public String deleteCustomer(@PathVariable("id") String cid){return "delete-7: "+ cid;
    }

}
