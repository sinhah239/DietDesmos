public class Main {
    public static void main(String[] args) {
        Grapher graph = new Grapher(10, 10, 4);
        graph.setEquation();
        System.out.println(graph.getEquation());
    }
}