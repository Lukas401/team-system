package pasta;

public class TimeDeFutebol extends Time{ // Classe filha de Time e tem finalidade de reaproveitar os dados gerais da classe mão, além de adicionar dados específicos para times de futebol
    protected String capitao;
    protected double aproveitamentoCasa;
    
    public TimeDeFutebol(String nome, String cidade, String tecnico, int anoFundacao, int tamanhoElenco, String capitao, double aproveitamentoCasa){
        super(nome, "Futebol", cidade, tecnico, anoFundacao, tamanhoElenco);
        this.capitao = capitao;
        this.aproveitamentoCasa = aproveitamentoCasa;
    }

    public String getCapitao() {
        return capitao;
    }

    public void setCapitao(String capitao) {
        this.capitao = capitao;
    }

    public double getAproveitamentoCasa() {
        return aproveitamentoCasa;
    }

    public void setAproveitamentoCasa(double aproveitamentoCasa) {
        this.aproveitamentoCasa = aproveitamentoCasa;
    }

}
