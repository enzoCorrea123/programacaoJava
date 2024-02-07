package FormasMatematicas.Formas;

public class Retangulo extends Forma {
    private double lado1, lado2;

    public Retangulo(double lado1, double lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double area() {
        return lado1 * lado2;
    }

    @Override
    public double perimetro() {
        return 2 * (lado1 + lado2);
    }

    @Override
    public String listar() {
        for (Forma forma : listaDeFormas){
            if(forma instanceof Retangulo){
                return forma.toString();
            }
        }
        return null;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    @Override
    public String toString() {
        return "Retangulo{" +
                "lado1=" + lado1 +
                ", lado2=" + lado2 +
                ", area=" + area() +
                ", perimetro=" + perimetro() +
                '}';
    }
}
