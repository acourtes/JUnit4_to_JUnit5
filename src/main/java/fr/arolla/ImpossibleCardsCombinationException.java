package fr.arolla;

public class ImpossibleCardsCombinationException extends Exception {
    private final String message;

    public ImpossibleCardsCombinationException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
