package FormasMatematicas.Formas;

public class Escaleno extends Triangulo {
    public Escaleno(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }

    private double semiperimetro() {
        return perimetro() / 2;
    }

    @Override
    public double area() {
        return Math.sqrt((semiperimetro() * (semiperimetro() - getLado1()) * (semiperimetro() - getLado2()) * (semiperimetro() - getLado3())));
    }
    @Override
    public String toString() {
        return "Escaleno{" +
                "Àrea=" + area() +
                ", Perímetro=" + perimetro() +
                '}';
    }
}
