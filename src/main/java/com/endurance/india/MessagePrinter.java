package com.endurance.india;

public class MessagePrinter {

    private String message;
    private int iterations;

    public void printMessage(){
        for (int i = 0; i < iterations; i++) {
            System.out.println(i+1 + ": " + message);
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIterations() {
        return iterations;
    }

    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}