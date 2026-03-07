package ru.yanes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

        SpaceShip spaceShip = new SpaceShip("Pobeda", 100);

        spaceShip.printReport();
        spaceShip.Jump(120, 12);
        spaceShip.initiateSelfDestruct();
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

class SpaceShip {
    private double fuelLevel;
    private String modelName;
    static NavigationSysyem navigationSysyem = new NavigationSysyem();
    Engine engine;

    SpaceShip(String modelName, double fuelLevel) {
        this.modelName = modelName;
        this.fuelLevel = fuelLevel;
        this.engine = new Engine();
    }

    void printReport(){
        class ReportFormatter {
            String getFormattedStatus(){
                return String.format("Shuttle: %s, Fuel level: %.2f.", modelName, fuelLevel);
            }
        }
        ReportFormatter reportFormatter = new ReportFormatter();
//        Function<String, Void> function = s -> System.out.println("hello");
        Consumer<String> consumer = s -> System.out.println(reportFormatter.getFormattedStatus());

        consumer.accept(modelName);
    }

    void initiateSelfDestruct(){
        Destructible destructible = () -> System.out.printf("Shuttle %s will be destroyed in 5 seconds!", modelName);
        destructible.destroy();
    }

    void Jump(double distance, double speed){

        Predicate<Double> canJump = f -> f > 12;
        JumpCalculator jumpCalculator = (dist,sp,fuel) -> dist/(sp*fuel);

        if (canJump.test(fuelLevel)) {

            double time = jumpCalculator.JumpCalculation(distance,speed,fuelLevel);
            System.out.printf("Jump will long %.2f \n.", time);
        } else {
            System.out.println("Jump failed, not enough fuel");
        }
    }



    class Engine {
        void setFuelLevel(double fuelLvl) {
            fuelLevel = fuelLvl;
        }

        void launch() {
            fuelLevel -= 10;
        }
    }

    static class NavigationSysyem {
        final static String galaxyName = "galaxy";
    }
}

@FunctionalInterface
interface Destructible {
    void destroy();
}

@FunctionalInterface
interface JumpCalculator {
    double JumpCalculation(double distance, double speed, double fuel);
}