package com.profectus.fishshop.fish;

import com.profectus.fishshop.color.Color;
import com.profectus.fishshop.env.Env;
import com.profectus.fishshop.size.Size;

public abstract class Fish {

    private Env env;
    private Color color;
    private Size size;
    private float price;
    private String description;

    public void setEnv(Env env) {
        this.env = env;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Env getEnv() {
        return env;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public abstract void swim();

}
