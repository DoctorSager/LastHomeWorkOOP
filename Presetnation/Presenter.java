package Presetnation;

import Logging.LogTxt;
import Logging.Logging;
import Operations.Divide;
import Operations.Model;
import Operations.Multiply;
import Operations.Substract;
import Operations.Summarize;
import Viev.UI;

public class Presenter <T extends Model> {
    UI v;
    T model;

    /**
     * Конструктор объекта типа Presenter
     * @param v - объект типа UI
     * @param model - объект типа Model
     */
    public Presenter(UI v, T model) {
        this.model = model;
        this.v = v;
    }

    public void runOperation() {
        Logging log = new LogTxt();
        String txt = "";
        Double x = v.inputDouble.apply("Введите первое число: ");
        Double y = v.inputDouble.apply("Введите второе число: ");
        int choice = v.getChoice();
        switch (choice) {
            case 1: {
                Summarize model = new Summarize();
                model.setX(x);
                model.setY(y);
                Double res = model.result();
                txt = log.getExpression(x, y, res, choice);
                System.out.println(res);
                break;
            }
            case 2: {
                Substract model = new Substract();
                model.setX(x);
                model.setY(y);
                Double res = model.result();
                txt = log.getExpression(x, y, res, choice);
                System.out.println(res);
                break;
            }
            case 3: {
                Multiply model = new Multiply();
                model.setX(x);
                model.setY(y);
                Double res = model.result();
                txt = log.getExpression(x, y, res, choice);
                System.out.println(res);
                break;
            }
            case 4: {
                Divide model = new Divide();
                model.setX(x);
                model.setY(y);
                Double res = model.result();
                txt = log.getExpression(x, y, res, choice);
                System.out.println(res);
                break;
            }
        }
        log.writeFile(txt, "Logging\\Saving.txt");
    }

}
