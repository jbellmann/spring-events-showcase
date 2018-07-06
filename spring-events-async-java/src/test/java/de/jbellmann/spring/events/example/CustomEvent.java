package de.jbellmann.spring.events.example;

public class CustomEvent {

    private final String name;

    public CustomEvent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
