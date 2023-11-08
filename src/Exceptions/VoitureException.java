package Exceptions;

public class VoitureException extends Exception {
    public VoitureException() {
        super("Voiture Exception");
    }

    public VoitureException(String message) {
        super(message);
    }
}


