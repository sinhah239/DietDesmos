import java.util.Arrays;
import java.util.Scanner;

public class Grapher {

    private BitImage image;
    private int n;
    private int m;

    private int coef[];

    public Grapher(int n, int m, int deg) {
        this.n = n;
        this.m = m;
        this.coef = new int[deg + 1];

        image = new BitImage(this.n, this.m);
    }

    public void setEquation() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < coef.length; i++) {
            System.out.print("Set the coefficient for the " + i + "th degree: ");
            coef[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println(Arrays.toString(coef));
    }

    public String getEquation() {
        String equation = "";
        for (int i = coef.length - 1; i >= 0; i--) {
            if (coef[i] > 0) {
                if (i == coef.length - 1) {
                    equation += "" + coef[i] + "x^" + i;
                } else if (i == 0){
                    equation += " + " + coef[i];
                } else {
                    equation += " + " + coef[i] + "x^" + i;
                }
            } else if (coef[i] < 0) {
                if (i == coef.length - 1) {
                    equation += "-" + (coef[i]*-1) + "x^" + i;
                } else if (i == 0){
                    equation += " - " + (coef[i]*-1);
                } else {
                    equation += " - " + (coef[i]*-1) + "x^" + i;
                }
            }
        }

        return equation;
    }

}
