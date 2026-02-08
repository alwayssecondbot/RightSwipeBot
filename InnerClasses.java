package ru.yanes;

import java.util.ArrayList;
import java.util.List;

public class InnerClasses {

    public static void main(String[] args) {
        SmartShelf shelf = new SmartShelf();
        shelf.addItem("Book", 12);
        shelf.addItem("Gook", 43);
        shelf.items.sort((o1, o2) -> o1.weight - o2.weight);

        System.out.println(shelf.items.get(1).name);
        Engine engine = new Engine(){

            private boolean isWorking = false;

            @Override
            public void start(){
                if (isWorking) {
                    System.out.println("already started");
                } else {
                    isWorking = true;
                    System.out.println("start");
                }
            }
            @Override
            public void stop(){
                if (isWorking) {
                    isWorking = false;
                    System.out.println("stop");
                } else {
                    System.out.println("already stopped");
                }
            }
        };

        engine.start();
    }
}

class SmartShelf {
    List<Item> items = new ArrayList<>();

    public void addItem(String name, int weight) {
        items.add(new Item(name, weight));
    }

    static class Item {
        String name;
        int weight;

        Item(String n, int w) {
            this.name = n;
            this.weight = w;
        }
    }
}

abstract class Engine {
    public void start() {
        System.out.println("start");
    }
    public void stop() {
        System.out.println("stop");
    }
}