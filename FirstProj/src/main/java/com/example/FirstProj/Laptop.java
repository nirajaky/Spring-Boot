package com.example.FirstProj;

import org.springframework.stereotype.Component;

@Component("lap")
public class Laptop {
    private int id;
    private String Brand;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }
    public void complie(){
        System.out.println("Compiling");
    }
}
