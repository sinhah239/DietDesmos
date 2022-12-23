import java.util.Arrays;
import java.util.Scanner;

public class Grapher {

    private BitImage image;
    private int n;
    private int m;

    private int coef[];

    public Grapher(int n, int m) {
        this.n = n;
        this.m = m;

        image = new BitImage(this.n, this.m);
    }

    public void setEquation() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Set equation degree: ");
        coef = new int[Integer.parseInt(scan.nextLine()) + 1];
        for (int i = 0; i < coef.length; i++) {
            if (i % 10 == 1 && i != 11) {
                System.out.print("Set the coefficient for the " + i + "st degree: ");
            } else if (i % 10 == 2 && i != 12) {
                System.out.print("Set the coefficient for the " + i + "nd degree: ");
            } else if (i % 10 == 3 && i != 13) {
                System.out.print("Set the coefficient for the " + i + "rd degree: ");
            } else {
                System.out.print("Set the coefficient for the " + i + "th degree: ");
            }
            coef[i] = Integer.parseInt(scan.nextLine());
        }
    }

    public String getEquation() {
        String equation = "y = ";
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] > 0) {
                if (i == coef.length - 1) {
                    equation += "" + (coef[i] == 1 ? "" : coef[i]) + (i == 1 ? "x" : ("x^" + i));
                } else if (i == 0){
                    equation += " + " + (coef[i] == 1 ? "1" : coef[i]);
                } else {
                    equation += " + " + (coef[i] == 1 ? "" : coef[i]) + (i == 1 ? "x" : ("x^" + i));
                }
            } else if (coef[i] < 0) {
                if (i == coef.length - 1) {
                    equation += "-" + (coef[i] == -1 ? "" : (coef[i]*-1)) + "x^" + (i == 1 ? "x" : ("x^" + i));
                } else if (i == 0){
                    equation += " - " + (coef[i] == -1 ? "1" : (coef[i]*-1));
                } else {
                    equation += " - " + (coef[i] == -1 ? "" : (coef[i]*-1)) + (i == 1 ? "x" : ("x^" + i));
                }
            }
        }
        return equation;
    }

    public int calculateY(int x) {
        int y = 0;
        for (int i = 0; i < coef.length; i++) {
            y += (coef[i] * Math.pow(x, i));
        }
        return y;
    }

    public int calculate() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter x value: ");
        int x = Integer.parseInt(scan.nextLine());
        int y = calculateY(x);
        System.out.println("y = " + y);
        return y;
    }

    public void setGraph() {
        for (int i = image.N() - 1; i >= 0; i--) {
            for (int j = 0; j < image.M(); j++) {
                if ((image.N() - 1 - i) == calculateY(j))
                    image.setPixel(i, j, true);
                else
                    image.setPixel(i, j, false);
            }
        }
    }

    public void printGraph() {
        System.out.println(image);
    }

}
