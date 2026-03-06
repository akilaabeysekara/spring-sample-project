package lk.ijse.dto;

/*
DTO class used to receive form-data from client.
Spring will automatically map form-data fields to this object.
*/

public class CustomerDTO {

    private String id;
    private String name;
    private String address;

    //Required default constructor
    public CustomerDTO() {
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    //Setters (VERY IMPORTANT for Spring binding)
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}