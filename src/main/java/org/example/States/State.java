/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

import main.java.org.example.Gumball;
import main.java.org.example.InvalidQuarterInput;
import main.java.org.example.Machine;
import main.java.org.example.Money;

import java.util.ArrayList;

public abstract class State {
    private final Machine gumballMachine;

    abstract public void insertQuarter(Money quarter) throws IllegalStateException, InvalidQuarterInput;
    abstract public double ejectQuarter() throws IllegalStateException;
    abstract public void selectTaste() throws IllegalStateException;
    abstract public void turnCrank() throws IllegalStateException;
    abstract public ArrayList<Gumball> dispense() throws IllegalStateException;

    public State(Machine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertGumballs(ArrayList<Gumball> gumballs) {
        gumballMachine.getGumballs().addAll(gumballs);
        if (gumballMachine.getState() == gumballMachine.getSoldState()) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
    }
}
