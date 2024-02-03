package FormasMatematicas.Formas;

public class Isoceles extends Triangulo{
    private double ladoDiferente, ladoIgual;
    public Isoceles(double lado1, double lado2, double lado3) {
        super(lado1, lado2, lado3);
    }
    private void verificarLadoDiferente(){
        if(getLado1() != getLado2() && getLado2() == getLado3()){
            ladoDiferente = getLado1();
            ladoIgual = getLado2();
        }else if(getLado2() != getLado3() && getLado3() == getLado1()){
            ladoDiferente = getLado2();
            ladoIgual = getLado1();
        }else if(getLado3() != getLado1() && getLado1() == getLado2()){
            ladoDiferente = getLado3();
            ladoIgual = getLado1();
        }
    }
    public double getAltura(){
        return Math.sqrt((Math.pow(ladoIgual,2) - (Math.pow(ladoDiferente,2)/4)));
    }
    @Override
    public double area() {
        return ladoDiferente * getAltura() * 0.5;
    }

    @Override
    public String toString() {
        return "Isoceles{" +
                "Àrea=" + area() +
                ", Perímetro=" + perimetro() +
                '}';
    }
}
