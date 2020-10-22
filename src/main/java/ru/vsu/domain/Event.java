package ru.vsu.domain;

public abstract class Event {

    private String name;
    private Type type;

    public Event() {
    }

    public Event(Type type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }


    @Override
    public String toString() {
        return "name = " + name;
    }
}
