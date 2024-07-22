/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

import main.java.org.example.Gumball;
import main.java.org.example.Machine;
import main.java.org.example.Money;

import java.util.ArrayList;

public class WinnerState extends State {
    private final Machine gumballMachine;

    public WinnerState(Machine gumballMachine) {
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
    public ArrayList<Gumball> dispense() {
        System.out.println("YOU'RE A WINNER! You get two gumballs for your quarter.");
        for (int i = 0; i < 2; i++) {
            if (gumballMachine.getGumballs().size() > 0) {
                gumballMachine.releaseBall(gumballMachine.getTasteInput()[i]);
            }
        }

        if (gumballMachine.getGumballs().size() == 0) {
            gumballMachine.setState(gumballMachine.getSoldState());
        } else {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        }
        ArrayList<Gumball> temp = new ArrayList<>(gumballMachine.getCurrentGumball());
        gumballMachine.getCurrentGumball().clear();
        return temp;
    }
}
