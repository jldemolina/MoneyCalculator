
import controller.ChangeRateController;
import java.io.IOException;
import java.util.GregorianCalendar;
import model.ChangeRate;
import model.Currency;
import view.ChangeRateView;
import model.Number;

public class Main {

    public static void main(String[] args) throws IOException {       
       ChangeRate model = new ChangeRate(new Number(0), new Currency("","",""), new Currency("","",""), new GregorianCalendar());
       ChangeRateView view = new ChangeRateView();
      
       ChangeRateController controller = new ChangeRateController(model, view);

       view.setVisible(true);
    }

}
