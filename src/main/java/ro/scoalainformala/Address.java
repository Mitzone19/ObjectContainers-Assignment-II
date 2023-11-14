package ro.scoalainformala;

public class Address {
    private String address;
    public Address(String address){
        this.address=address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String name) {
        this.address = name;
    }
    @Override
    public String toString(){
        return "This hobby can be done at "+address;
    }
}
