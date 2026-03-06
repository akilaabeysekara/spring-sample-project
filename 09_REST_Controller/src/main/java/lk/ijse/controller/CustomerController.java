package lk.ijse.controller;

import lk.ijse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    /*
     * HTTP requests can send data in several places:
     *
     * 1. URL
     *      - Path Variables
     *      - Query Parameters
     *
     * 2. Headers
     *      - Authorization tokens
     *      - Content-Type
     *
     * 3. Body
     *      - x-www-form-urlencoded
     *      - form-data
     *      - JSON
     *      - XML
     */

    //------------------------------------------------------------------------------------------------

    /*
     * POST mapping - Save customer using QUERY PARAMETERS
     *
     * Example request:
     * POST http://localhost:8080/api/v1/customer/save1?id=C001&name=Akila&address=Galle
     */

    @PostMapping("/save1")
    public String saveCustomerRequestParams(
            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("address") String address){

        return "saved-1 using query params : " + id + " " + name + " " + address;
    }

    //------------------------------------------------------------------------------------------------

    /*
     * POST mapping - Save customer using x-www-form-urlencoded
     *
     * Postman → Body → x-www-form-urlencoded
     *
     * Request body format:
     * id=C001&name=Akila&address=Galle
     * In modern REST APIs, we normally use JSON instead of x-www-form-urlencoded
     */

    @PostMapping("/save2")
    public String saveCustomerBodyXWWWFormUrlEncoded(

            @RequestParam("id") String id,
            @RequestParam("name") String name,
            @RequestParam("address") String address) {

        return "saved-2 using x-www-form-urlencoded : " + id + " " + name + " " + address;
    }

    //------------------------------------------------------------------------------------------------

    /*
     * POST mapping - Save customer using FORM-DATA
     *
     * Postman → Body → form-data
     *
     * Key       Value
     * id        C001
     * name      Akila
     * address   Galle
     *
     * We use @ModelAttribute so Spring can bind multipart/form-data fields
     * directly into the DTO object.
     * In modern REST APIs, we normally use JSON instead of form-data
     */

    @PostMapping("/save3")
    public String saveCustomerBodyFormData(@ModelAttribute CustomerDTO dto) {

        return "saved-3 using form-data : "
                + dto.getId() + " "
                + dto.getName() + " "
                + dto.getAddress();
    }

    //------------------------------------------------------------------------------------------------

    /*
     * PUT mapping - Update entire customer resource
     */

    @PutMapping("/update")
    public String updateCustomer(

            @RequestParam("name") String name,
            @RequestParam("id") String id,
            @RequestParam("address") String address) {

        return "updated-4 : " + name + " " + id + " " + address;
    }

    //------------------------------------------------------------------------------------------------

    /*
     * PATCH mapping - Partial update
     * Uses path variable + query parameter
     */

    @PatchMapping("/{id}")
    public String partialUpdateCustomer(

            @PathVariable("id") String id,
            @RequestParam("address") String address) {

        return "partial-update-5 : " + id + " address : " + address;
    }

    //------------------------------------------------------------------------------------------------

    /*
     * GET mapping - Search using query parameter
     */

    @GetMapping("/search")
    public String searchCustomer(@RequestParam("id") String id){

        return "search-6 : " + id;
    }

    //------------------------------------------------------------------------------------------------

    /*
     * DELETE mapping - Delete using path variable
     */

    @DeleteMapping("/{id}")
    public String deleteCustomer(@PathVariable("id") String cid){

        return "delete-7 : " + cid;
    }

}