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
        return "saved-1 " + id + " " + name + " " + address;
    }

    //POST mapping - Save entire customer resource using form data in request body or x-www-form-urlencoded
    //In modern REST APIs, we normally use JSON instead of form-data
    @PostMapping("/save2")
    public String saveCustomerBodyFormData(
            @RequestParam String id,
            @RequestParam String name,
            @RequestParam String address) {
        return "saved-2 " + id + " " + name + " " + address;
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
