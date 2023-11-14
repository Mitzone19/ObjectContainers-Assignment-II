package ro.scoalainformala;

import java.util.ArrayList;
import java.util.List;

public class Hobby {
    private String name;
    private int freq;
    private List<Address> addressesList;
    public Hobby(String name,int freq){
        this.name=name;
        this.freq=freq;
        this.addressesList=new ArrayList<>();
    }
    public void addAddress(Address address){
        addressesList.add(address);
    }
    public String getName(){
        return name;
    }
    public List<Address> getAddresses(){
        return addressesList;
    }
    @Override
    public String toString() {
        return name + " (Frequency: " + freq + " times/week)";
    }
}
