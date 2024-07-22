/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

import main.java.org.example.Gumball;
import main.java.org.example.Machine;
import main.java.org.example.Money;

import java.util.ArrayList;
import java.util.Random;

public class HasQuarterState extends State {
    Random randomWinner = new Random(System.currentTimeMillis());
    private final Machine gumballMachine;

    public HasQuarterState(Machine gumballMachine) {
        super(gumballMachine);
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter(Money quarter) throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }

    @Override
    public double ejectQuarter() {
        gumballMachine.setState(gumballMachine.getNoQuarterState());
        double money = gumballMachine.getCurrentMoney().getValue();
        gumballMachine.setCurrentMoney(null);
        return money;
    }

    @Override
    public void selectTaste() {
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void turnCrank() {
        int winner = randomWinner.nextInt(10);
        if ((winner == 0)) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        gumballMachine.getTotalQuarters().add(gumballMachine.getCurrentMoney());
        gumballMachine.setCurrentMoney(null);
    }

    @Override
    public ArrayList<Gumball> dispense() throws IllegalStateException {
        throw new IllegalStateException(gumballMachine.getCurrentState());
    }
}
