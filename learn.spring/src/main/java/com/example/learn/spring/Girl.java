package com.example.learn.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Girl {

    @Autowired
    Outfit outfit;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Girl(" + "Outfit: " + this.outfit + " name: " + this.name + ")";
    }
}
