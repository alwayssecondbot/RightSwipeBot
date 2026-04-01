package ru.yanes;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class SpaceShip {
    private double fuelLevel;
    private String modelName;
    static NavigationSysyem navigationSysyem = new NavigationSysyem();
    Engine engine;

    public SpaceShip(String modelName, double fuelLevel) {
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
