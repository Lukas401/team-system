package pasta;

public class TimeDeBasquete extends Time{ // Classe filha de Time e tem finalidade de reaproveitar os dados gerais da classe mão, além de adicionar dados específicos para times de basquete
    protected double mediaAltura;
    protected double aproveitamentoTiroLivre;
    
    public TimeDeBasquete(String nome, String cidade, String tecnico, int anoFundacao, int tamanhoElenco, double mediaAltura, double aproveitamentoTiroLivre){
        super(nome, "Basquete", cidade, tecnico, anoFundacao, tamanhoElenco);  
        this.aproveitamentoTiroLivre = aproveitamentoTiroLivre;
        this.mediaAltura = mediaAltura;
    }

    public double getAproveitamentoTiroLivre() {
        return aproveitamentoTiroLivre;
    }

    public void setAproveitamentoTiroLivre(double aproveitamentoTiroLivre) {
        this.aproveitamentoTiroLivre = aproveitamentoTiroLivre;
    }

    public double getMediaAltura() {
        return mediaAltura;
    }

    public void setMediaAltura(double mediaAltura) {
        this.mediaAltura = mediaAltura;
    }

}
