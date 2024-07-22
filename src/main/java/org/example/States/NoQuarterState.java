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

public class NoQuarterState extends State {
    private final Machine gumballMachine;

    public NoQuarterState(Machine gumballMachine) {
        super(gumballMachine);
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter(Money quarter) throws InvalidQuarterInput {
        System.out.println("You inserted a quarter");
        if (quarter.getValue() == 0.25) {
            gumballMachine.setState(gumballMachine.getSelectTasteState());
            gumballMachine.setCurrentMoney(quarter);
        } else {
            throw new InvalidQuarterInput("You inserted the wrong coin!");
        }
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
