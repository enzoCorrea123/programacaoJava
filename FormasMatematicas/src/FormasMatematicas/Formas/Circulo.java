package FormasMatematicas.Formas;

public class Circulo extends Forma{
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    public double diametro(){
        return raio * 2;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public double perimetro() {
        return 2 * Math.PI * raio;
    }

    @Override
    public String listar() {
        String lista = "";
        for (Forma forma : listaDeFormas){
            if(forma instanceof Circulo){
                lista += forma.toString();
            }
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Circulo{" +
                "Àrea=" + area() +
                ", Perímetro=" + perimetro() +
                '}';
    }
}
