/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

import main.java.org.example.Gumball;
import main.java.org.example.Machine;
import main.java.org.example.Money;

import java.util.ArrayList;

public class SoldOutState extends State {
    private final Machine gumballMachine;

    public SoldOutState(Machine gumballMachine) {
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
    public void selectTaste() throws  IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
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
