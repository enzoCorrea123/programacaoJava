package FormasMatematicas;

public class Professor {
    private int senha, quantidadeTentativas, tentativas;

    public int getSenha() {
        return senha;
    }
    public Professor(){
        senha = 123;
        quantidadeTentativas = 3;
        tentativas = 0;
    }

    public int getTentativas() {
        return tentativas;
    }

    public void setTentativas(int tentativas) {
        this.tentativas = tentativas;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getQuantidadeTentativas() {
        return quantidadeTentativas;
    }

    public void setQuantidadeTentativas(int quantidadeTentativas) {
        this.quantidadeTentativas = quantidadeTentativas;
    }

    public boolean verificarSenha(int senha){
        if(this.senha == senha){
            return true;
        }
        return false;
    }

}
