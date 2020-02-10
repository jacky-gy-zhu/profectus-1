package com.profectus.fishshop.fish;

import com.profectus.fishshop.color.Color;
import com.profectus.fishshop.composite.Species;
import com.profectus.fishshop.decorator.Settlement;
import com.profectus.fishshop.env.Env;
import com.profectus.fishshop.size.Size;

import java.io.*;

public abstract class Fish implements Settlement, Cloneable, Serializable {

    private Env env;
    private Color color;
    private Size size;
    private Species species;
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

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Species getSpecies() {
        return species;
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

    @Override
    protected Fish clone() throws CloneNotSupportedException {
        // shallow clone
        return (Fish) super.clone();
    }

    public Fish deepClone() {

        // deep clone
        try (
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)
        ) {
            // serialize this object
            objectOutputStream.writeObject(this);

            // anti-serialize this object
            try (
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream)
            ) {
                return (Fish) objectInputStream.readObject();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
