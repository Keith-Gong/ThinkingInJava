package com.keith.reflect;

import java.util.Arrays;
import java.util.List;

/**
 * Created by keith on 8/27/2015.
 */
public class RobotTest {
}

interface Operation {
    String description();

    void command();
}

interface Robot {
    String name();

    String model();

    List<Operation> operations();

    class Test {
        public static void test(Robot r) {
            if (r instanceof Null) {
                System.out.println("Null Robot");
            }
            System.out.println("name : " + r.name());
            System.out.println("model : " + r.model());
            for (Operation operation : r.operations()) {
                System.out.println(operation.description());
                operation.command();
            }
        }
    }
}

class SnowRemovalRobot implements Robot {
    private String name;

    public SnowRemovalRobot(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public String model() {
        return "SnowBot 1";
    }

    @Override
    public List<Operation> operations() {
        return Arrays.asList(
                new Operation() {
                    @Override
                    public String description() {
                        return name + "remove snow";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chipping snow");
                    }
                },
                new Operation() {
                    @Override
                    public String description() {
                        return name + "remove snow1";
                    }

                    @Override
                    public void command() {
                        System.out.println(name + " chipping snow1");
                    }
                });

    }
}