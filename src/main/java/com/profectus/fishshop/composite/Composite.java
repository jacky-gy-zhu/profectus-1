package com.profectus.fishshop.composite;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Species {

    private String name;
    private List<Species> list = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void add(Species species) {
        list.add(species);
    }

    public void remove(Species species) {
        list.remove(species);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getFamilyTree() {
        StringBuilder builder = new StringBuilder();
        builder.append(getName() + " > ");
        tree(builder);
        return builder.toString();
    }

    private void tree(StringBuilder builder) {
        for (Species species : list) {
            if (species instanceof Composite) {
                builder.append(species.getName() + " > ");
                ((Composite) species).tree(builder);
            } else {
                builder.append(species.getName());
            }
        }
    }
}
