/*
    6510405806
    Weeranut Chayakul
*/

package main.java.org.example.States;

public class IllegalStateException extends Exception {
    public IllegalStateException(String currentState) {
        super("Error: " + currentState);
    }
}
