public class BitImage {
    private char[][] bits;

    public BitImage(int n, int m) {
        bits = new char[n][m];
    }

    public void setPixel(int n, int m, boolean drawn) {
        if (n >= bits.length || m >= bits[0].length)
            System.out.println("Error! Pixel does not exist!");
        else if (drawn) {
            bits[n][m] = '.';
        } else {
            bits[n][m] = ' ';
        }
    }

    public String toString() {
        String image = "";
        for (int i = 0; i < bits.length; i++) {
            for (int j = 0; j < bits[0].length; j++) {
                image += bits[i][j];
            }
            image += "\n";
        }
        return image;
    }

    public int N() {
        return bits.length;
    }

    public int M() {
        return bits[0].length;
    }

}
