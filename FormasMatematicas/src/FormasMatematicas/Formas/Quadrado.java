package FormasMatematicas.Formas;

public class Quadrado extends Forma{
    private double lado;

    public Quadrado(double lado) {
        this.lado = lado;
    }
    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return lado * 4;
    }

    @Override
    public void listar() {
        for (Forma forma : listaDeFormas){
            if(forma instanceof Quadrado){
                forma.toString();
            }
        }
    }

    @Override
    public String toString() {
        return "Quadrado{" +
                "Àrea=" + area() +
                ", Perímetro=" + perimetro() +
                '}';
    }
}
