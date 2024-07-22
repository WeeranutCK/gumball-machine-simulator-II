/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

import main.java.org.example.Gumball;
import main.java.org.example.Machine;
import main.java.org.example.Money;

import java.util.ArrayList;

public class SelectTasteState extends State {
    private final Machine gumballMachine;

    public SelectTasteState(Machine gumballMachine) {
        super(gumballMachine);
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter(Money quarter) throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }

    @Override
    public double ejectQuarter() throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }

    @Override
    public void selectTaste() {
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void turnCrank() throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }

    @Override
    public ArrayList<Gumball> dispense() throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }
}
