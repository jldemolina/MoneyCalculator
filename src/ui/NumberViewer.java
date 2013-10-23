package ui;

public class NumberViewer {
    
    private final Number number;

    public NumberViewer(Number number) {
        this.number = number;
    }
    
    public void show() {
        System.out.println(number);
    }
}
