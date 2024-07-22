/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static ArrayList<Gumball> generateRandomGumball(int n) {
        ArrayList<Gumball> gumballs = new ArrayList<>();
        String[] taste = {"Mango", "Orange", "Apple", "Grapes", "Melon"};

        for (int i = 0; i < n; i++) {
            Random random = new Random();
            int index = random.nextInt(taste.length);
            Gumball gumBall = new Gumball(taste[index]);
            gumballs.add(gumBall);
        }
        return gumballs;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input number of gumballs: ");
        int n =  Integer.parseInt(bufferedReader.readLine());

        ArrayList<Gumball> gumballs = generateRandomGumball(n);
        Machine machine = new Machine(gumballs);

        while (true) {
            System.out.println("\n" + machine);
            System.out.print("Input state [A]add gumball, [I]nsert coin, [S]elect taste, [E]ject, [T]urn Crank, [D]ispense Gumball, [Q]uit: ");
            String input = bufferedReader.readLine();

            switch (input.toUpperCase()) {
                case "A" -> {
                    System.out.print("Input number of gumballs to insert: ");
                    n =  Integer.parseInt(bufferedReader.readLine());
                    gumballs = generateRandomGumball(n);
                    machine.insertGumBalls(gumballs);
                }
                case "I" -> {
                    try {
                        System.out.print("Insert money amount: ");
                        double amount = Double.parseDouble(bufferedReader.readLine());
                        Money quarter = new Money(amount);
                        machine.insertQuarter(quarter);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "E" -> {
                    try {
                        double money = machine.ejectQuarter();
                        System.out.println("Money amount: " + money + " was returned!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "T" -> {
                    try {
                        System.out.println("You turned...");
                        machine.turnCrank();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "S" -> {
                    try {
                        machine.selectTaste();
                        System.out.print("Insert first taste: ");
                        String firstTaste = bufferedReader.readLine();
                        System.out.print("Insert second taste: ");
                        String secondTaste = bufferedReader.readLine();
                        machine.setTasteInput(new String[]{firstTaste, secondTaste});
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "D" -> {
                    try {
                        machine.dispense();
                        if (machine.getState() == machine.getSoldOutState()) {
                            if (machine.getCurrentGumball() != null) {
                                for (int i = 0; i < machine.getCurrentGumball().size(); i++) {
                                    System.out.println("The gumball color is: " + machine.getCurrentGumball().get(i).getTaste());
                                }
                            } else {
                                System.out.println("You turned, but there are no gumballs");
                            }
                            System.out.println("Oops, out of gumballs!");
                            System.out.println("You can't insert a quarter, the machine is sold out");
                        }
                        machine.setTasteInput(null);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case "Q" -> {
                    return;
                }
            }
        }
    }
}
