package FormasMatematicas;

import FormasMatematicas.Formas.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Professor professor = new Professor();
        while (professor.getTentativas()<professor.getQuantidadeTentativas()){
            System.out.println("Digite a senha:");
            int senha = sc.nextInt();
            if(professor.verificarSenha(senha)){
                break;
            }else{
                professor.setTentativas(professor.getTentativas()+1);
            }


        }
        if(professor.getTentativas() == 3){
            System.exit(0);
        }
        System.out.println("Bem vindo ao sistema do Elvis Schmidt! O que deseja fazer?");
        System.out.println("1 - Cadastrar forma\n2 - Listar forma\n3 - Logout");
        int opcao1 = sc.nextInt();
        switch (opcao1){
            case 1:
                System.out.println("Digite a forma geométrica:\n1 - Circulo\n2 - Retângulo\n3 - Quadrado\n4 - Triângulo");
                int opcao2 = sc.nextInt();
                switch (opcao2){
                    case 1:
                        System.out.println("Digite o raio do circulo:");
                        double raio = sc.nextDouble();
                        Forma circulo = new Circulo(raio);
                        circulo.AdicionarForma(circulo);
                        break;
                    case 2:
                        System.out.println("Digite a base do retângulo");
                        double base = sc.nextDouble();
                        System.out.println("Digite a altura do retângulo");
                        double altura = sc.nextDouble();
                        Forma retangulo = new Retangulo(base,altura);
                        retangulo.AdicionarForma(retangulo);
                        break;
                    case 3:
                        System.out.println("Digite o lado do quadrado:");
                        double lado = sc.nextDouble();
                        Forma quadrado = new Quadrado(lado);
                        quadrado.AdicionarForma(quadrado);
                        break;
                    case 4:
                        double lado1,lado2,lado3;
                        Forma triangulo;
                        System.out.println("Digite o primeiro lado do triangulo:");
                        lado1 = sc.nextDouble();
                        System.out.println("Digite o primeiro lado do triangulo:");
                        lado2 = sc.nextDouble();
                        System.out.println("Digite o primeiro lado do triangulo:");
                        lado3 = sc.nextDouble();
                        if(lado1 == lado2 && lado2 == lado3){
                            triangulo = new Equilatero(lado1,lado2,lado3);

                        }else if(lado1 != lado2 && lado2 != lado3){
                            triangulo = new Escaleno(lado1,lado2,lado3);
                        }else{
                            triangulo = new Isoceles(lado1,lado2,lado3);
                        }
                        triangulo.AdicionarForma(triangulo);
                        break;

                }
                break;
            case 2:
                break;
            case 3:
                System.exit(0);
                break;
        }

    }
}
