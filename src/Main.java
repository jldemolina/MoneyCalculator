
import controller.CalculatorController;
import java.io.IOException;
import model.Calculator;
import view.CalculatorView;

public class Main {

    public static void main(String[] args) throws IOException {
            Calculator model = new Calculator();
            CalculatorView view = new CalculatorView();
            
            CalculatorController controller = new CalculatorController(model, view);
            
            view.setVisible(true);     
    }

}
