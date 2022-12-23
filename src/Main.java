public class Main {
    public static void main(String[] args) {
        Grapher graph = new Grapher(100, 100);
        graph.setEquation();
        System.out.println(graph.getEquation());
        graph.setGraph();
        graph.printGraph();
    }
}