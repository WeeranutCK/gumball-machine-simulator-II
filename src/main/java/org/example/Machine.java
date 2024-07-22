/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example;

import main.java.org.example.States.*;
import main.java.org.example.States.IllegalStateException;

import java.util.ArrayList;

public class Machine {
    private final ArrayList<Gumball> gumballs;
    private final ArrayList<Money> totalQuarters;
    private ArrayList<Gumball> currentGumballs;
    private String tasteInput[];
    private Money currentMoney;
    private State soldOutState;
    private State noQuarterState;
    private State hasQuarterState;
    private State soldState;
    private State winnerState;
    private State selectTasteState;
    private State state;

    public Machine(ArrayList<Gumball> gumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        selectTasteState = new SelectTasteState(this);

        if (gumballs.size() == 0) {
            state = soldOutState;
        } else {
            state = noQuarterState;
        }

        this.gumballs = gumballs;
        totalQuarters = new ArrayList<>();
        currentGumballs = new ArrayList<>();
    }

    public void insertGumBalls(ArrayList<Gumball> gumballs) {
        state.insertGumballs(gumballs);
    }

    public void insertQuarter(Money quarter) throws IllegalStateException, InvalidQuarterInput {
        state.insertQuarter(quarter);
    }

    public double ejectQuarter() throws IllegalStateException {
        return state.ejectQuarter();
    }

    public void turnCrank() throws IllegalStateException {
        state.turnCrank();
    }

    public void dispense() throws IllegalStateException {
        state.dispense();
    }

    public void selectTaste() throws IllegalStateException {
        state.selectTaste();
    }

    public Gumball findGumballWithTaste(String taste) {
        for (Gumball gumball : gumballs) {
            if (gumball.getTaste().equals(taste)) {
                return gumball;
            }
        }
        return null;
    }

    public void releaseBall(String taste) {
        Gumball temp = findGumballWithTaste(taste);
        if (temp == null) {
            System.out.println("Gumball out of " + taste + " taste..");
        } else {
            System.out.println("A gumball comes rolling out the slot...");
            if (gumballs.size() != 0) {
                gumballs.remove(temp);
                currentGumballs.add(temp);
            } else {
                currentGumballs.clear();
            }
        }
    }

    public Money getCurrentMoney() {
        return currentMoney;
    }

    public void setCurrentMoney(Money currentMoney) {
        this.currentMoney = currentMoney;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public State getSelectTasteState() {
        return selectTasteState;
    }

    public ArrayList<Gumball> getGumballs() {
        return gumballs;
    }

    public ArrayList<Money> getTotalQuarters() {
        return totalQuarters;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public ArrayList<Gumball> getCurrentGumball() {
        return currentGumballs;
    }

    public String[] getTasteInput() {
        return tasteInput;
    }

    public void setTasteInput(String[] tasteInput) {
        this.tasteInput = tasteInput;
    }

    @Override
    public String toString() {
        return "Mighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\n" +
                "Inventory: " + gumballs.size() + " gumball(s)\n" +
                "Machine Stored Money: $" + getMoneyFromMachine() + "\n" +
                "Current State: " + getCurrentState() + "\n";
    }

    public String getCurrentState() {
        if (state == noQuarterState) {
            return "Machine is waiting for quarter";
        } else if (state == hasQuarterState) {
            return "Machine still has quarter";
        } else if (state == soldState) {
            return "There are gumballs in the tray";
        } else if (state == soldOutState) {
            return "Machine is sold out";
        } else if (state == winnerState) {
            return "Machine is at winning!";
        } else if (state == selectTasteState) {
            return "Machine is waiting for taste input";
        } else {
            return "Unknown state";
        }
    }

    public double getMoneyFromMachine() {
        double money = 0;
        for (Money each : totalQuarters) {
            money += each.getValue();
        }
        return money;
    }
}
