package pasta;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) { // Função principal do sistema
        ArrayList<TimeDeFutebol> listaTimesFutebol = new ArrayList<TimeDeFutebol>(); // Criação de uma Arraylist do tipo timeDeFutebol
        ArrayList<TimeDeBasquete> listaTimesBasquete = new ArrayList<TimeDeBasquete>(); // Criação de uma Arraylist do tipo timeDeBasquete
        cadastroAutomatico(listaTimesFutebol, listaTimesBasquete); 
        menuPrincipal(listaTimesFutebol, listaTimesBasquete);
    }
    
    public static void menuPrincipal(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que chama e executa todas as possíveis opções do menu principal do sistema
        boolean finalizar = false;
        int modalidade, opcao;
        
        do{ // Laço de repetição DO-WHILE para repetir o menu enquanto a opção selecionada seja diferente de "5"
            opcao = escolhaMenu("Digite sua opção: ");
            switch(opcao){
                case 1:
                    modalidade = escolhaModalidades("Digite a modalidade do time que será cadastrado: ");
                    cadastroManual(modalidade, listaTimesFutebol, listaTimesBasquete);
                    break;
                case 2:
                    editarTime(listaTimesFutebol, listaTimesBasquete);
                    break;
                case 3:
                    excluirTime(listaTimesFutebol, listaTimesBasquete);
                    break;
                case 4:
                    tipoListagem("Digite a sua opção: ", listaTimesFutebol, listaTimesBasquete);
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Finalizando o sistema...");
                    finalizar = true;
            }
        }while(finalizar == false);
    }
    
    public static int escolhaMenu(String frase){ // Função que imprime o menu e depois recebe um valor do usuário
        int escolha = 0;
        while(escolha < 1 || escolha > 5){
            System.out.println();
            System.out.println("--------------- MENU ---------------");
            System.out.println("1| Cadastrar time");
            System.out.println("2| Editar time");
            System.out.println("3| Excluir time");
            System.out.println("4| Listar times");
            System.out.println("5| Finalizar o programa");
            escolha = lerInt(frase);}
        return escolha;
    }
    
    public static int escolhaAtributoEdit(String frase, int modalidade){ // Função que imprime todos os possíveis atributos dependendo da modalidade do time, após isso, recebe um valor do usuário
        System.out.println("1| Nome");
        System.out.println("2| Cidade");
        System.out.println("3| Técnico");
        System.out.println("4| Ano de fundação");
        System.out.println("5| Tamanho do elenco");
        if (modalidade == 1){
            System.out.println("6| Capitão");
            System.out.println("7| Aproveitamento como mandante");  
        }
        else{
            System.out.println("6| Média de altura");
            System.out.println("7| Aproveitamento em tiro livre");
        }

        return lerInt(frase);
    }
    
    public static int escolhaModalidades(String frase){ // Imprime um mini Menu para o usuário selecionar a modalidade do time
        System.out.println();
        System.out.println("1| Futebol");
        System.out.println("2| Basquete");
        return lerInt(frase);
    }
            
    public static void cadastroAutomatico(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que cadastra 7 objetos e insere dentro das suas respectivas Arraylists
        listaTimesFutebol.add(new TimeDeFutebol("TimeA", "Salvador", "João Gomes", 2022, 24, "Pedro", 100));
        listaTimesFutebol.add(new TimeDeFutebol("TimeB", "Santo Antônio de Jesus", "Abel Braga", 1999, 33, "Davi", 42.8));
        listaTimesFutebol.add(new TimeDeFutebol("TimeC", "Recife", "Mano Menezes", 1957, 22, "Ramon", 78.5));
        listaTimesBasquete.add(new TimeDeBasquete("TimeD", "São Paulo", "Pedrinho", 2020, 24, 1.92, 75));
        listaTimesBasquete.add(new TimeDeBasquete("TimeE", "Rio de Janeiro", "Jorge Jesus", 2010, 24, 1.90, 81.4));
        listaTimesBasquete.add(new TimeDeBasquete("TimeF", "Granada", "Gonçalves", 2021, 24, 1.91, 71.2));
        listaTimesBasquete.add(new TimeDeBasquete("TimeG", "Lisboa", "Mourinho", 1993, 24, 1.89, 77)); 
    }
    
    public static void cadastroManual(int modalidade, ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que permite o usuário cadastrar manualmente um novo objeto, além de inserir na sua respectiva lista
        String nome, cidade, tecnico;
        int anoFundacao, tamanhoElenco; 
        boolean existe = false;

        nome = lerString("Digite o nome do time: ");
        cidade = lerString("Digite a cidade em que o " + nome + " foi fundado: ");
        anoFundacao = lerInt("Digite o ano em que o " + nome + " nasceu: ");
        tecnico = lerString("Digite o nome do técnico atual: ");
        tamanhoElenco = lerInt("Digite o tamanho do elenco de jogadores: ");
        
        if(modalidade == 1){ // Verifica a modalidade do time que será cadastrado
            String capitao = lerString("Digite o nome do capitão do time: ");
            double aproveitamentoCasa = lerDouble("Digite o aproveitamento em casa do time na atual temporada: ");
            
            for (TimeDeFutebol time : listaTimesFutebol){
                if (time.nome.equals(nome)){
                    System.out.println("Já tem um time registrado com esse nome.");
                    existe = true;
                    break;
                }
            }   

            if(existe == false){
                TimeDeFutebol NovoTime = new TimeDeFutebol(nome, cidade, tecnico, anoFundacao, tamanhoElenco, capitao, aproveitamentoCasa);  
                listaTimesFutebol.add(NovoTime);
            }  
        }
        else{
            double mediaAltura = lerDouble("Digite a média de altura do time: ");
            double aproveitamentoTiroLivre = lerDouble("Digite o aproveitamento de tiro livre geral do time: ");
            
            for (TimeDeBasquete time : listaTimesBasquete){
                if (time.nome.equals(nome)){
                    System.out.println("Já tem um time registrado com esse nome.");
                    existe = true;
                    break;
                }
            } 

            if(existe == false){
                TimeDeBasquete NovoTime = new TimeDeBasquete(nome, cidade, tecnico, anoFundacao, tamanhoElenco, mediaAltura, aproveitamentoTiroLivre);
                listaTimesBasquete.add(NovoTime);
            }
        }  
    }
    
    public static void editarTime(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que permite o usuário editar todos os dados do time, exceto sua modalidade
        boolean verificacaoFutebol = false, verificacaoBasquete = false, existe = false;
        int decisao;
        
        String timeEscolhido = lerString("Digite o nome do time que você deseja alterar: ");
        
        for (TimeDeFutebol time : listaTimesFutebol){ // Laço de repetição For que tem como objetivo passar por todos os times presentes na Arraylist listaTimesFutebol 
            if (time.nome.equals(timeEscolhido)){ // Estrutura condicional if que verifica se o time faz parte da lista através do seu nome
                verificacaoFutebol = true;
                decisao = escolhaAtributoEdit("Digite o atributo que você deseja alterar: ", 1);
                switch (decisao){
                    case 1:
                        String nome = lerString("Digite o novo nome: ");
                        for (TimeDeFutebol timeFutebol : listaTimesFutebol){
                            if (timeFutebol.nome.equals(nome)){
                                System.out.println("Edição inválida! Já tem um time registrado com esse nome.");
                                existe = true;
                                break;
                            }
                        }
                        if(existe == false){
                            time.setNome(nome);}
                        break;
                    case 2:
                        String cidade = lerString("Digite a nova cidade: ");
                        time.setCidade(cidade);
                        break;
                    case 3:
                        String tecnico = lerString("Digite o novo tecnico: ");
                        time.setTecnico(tecnico);
                        break;
                    case 4:
                        int ano = lerInt("Digite o novo ano de fundação: ");
                        time.setAnoFundacao(ano);
                        break;
                    case 5:
                        int elenco = lerInt("Digite o tamanho do novo elenco: ");
                        time.setTamanhoElenco(elenco);
                        break;
                    case 6:
                        String capitao = lerString("Digite o nome do novo capitão: ");
                        time.setCapitao(capitao);
                        break;
                    case 7:
                        double aproveitamentoCasa = lerDouble("Digite o aproveitamento em casa atualizado: ");
                        time.setAproveitamentoCasa(aproveitamentoCasa);
                        break;
                }
                System.out.println("Time alterado.");
                break;
            }   
        }
        for (TimeDeBasquete time : listaTimesBasquete){ // Laço de repetição For que tem como objetivo passar por todos os times presentes na Arraylist listaTimesBasquete
            if (time.nome.equals(timeEscolhido)){ // Estrutura condicional if que verifica se o time faz parte da lista através do seu nome
                verificacaoBasquete = true;
                decisao = escolhaAtributoEdit("Digite o atributo que você deseja alterar: ", 2);
                switch (decisao){
                    case 1:
                        String nome = lerString("Digite o novo nome: ");
                        for (TimeDeBasquete timeBasquete : listaTimesBasquete){
                            if (timeBasquete.nome.equals(nome)){
                                System.out.println("Edição inválida! Já tem um time registrado com esse nome.");
                                existe = true;
                                break;
                            }
                        }
                        if(existe == false){
                            time.setNome(nome);}
                        break;
                    case 2:
                        String cidade = lerString("Digite a nova cidade: ");
                        time.setCidade(cidade);
                        break;
                    case 3:
                        String tecnico = lerString("Digite o novo tecnico: ");
                        time.setTecnico(tecnico);
                        break;
                    case 4:
                        int ano = lerInt("Digite o novo ano de fundação: ");
                        time.setAnoFundacao(ano);
                        break;
                    case 5:
                        int elenco = lerInt("Digite o tamanho do novo elenco: ");
                        time.setTamanhoElenco(elenco);
                        break;
                    case 6:
                        double altura = lerDouble("Digite a nova média de altura do time: ");
                        time.setMediaAltura(altura);
                        break;
                    case 7:
                        double aproveitamento = lerDouble("Digite a nova porcentagem de aproveitamento geral de tiro livre do time: ");
                        time.setAproveitamentoTiroLivre(aproveitamento);
                        break;
                }
                System.out.println("Time alterado.");
                break;
            }   
        }
        
        if (verificacaoBasquete == false && verificacaoFutebol == false){ // Verifica se o time existe em alguma das duas listas
            System.out.println("Esse time não está cadastrado.");
        }
    }
    
    public static void excluirTime(ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que permite o usuário excluir um objeto através do seu nome
        boolean verificacaoFutebol = false, verificacaoBasquete = false;
        int decisao;
        
        String timeEscolhido = lerString("Digite o nome do time que você deseja excluir: ");
        
        for (TimeDeFutebol time : listaTimesFutebol){
            if (time.nome.equals(timeEscolhido)){
                verificacaoFutebol = true;
                decisao = confirmacao("Realmente deseja excluir esse clube? ");
                if (decisao == 1){
                    listaTimesFutebol.remove(time);
                    System.out.println("Time removido.");
                }
                break;
            }   
        }
        for (TimeDeBasquete time : listaTimesBasquete){
            if (time.nome.equals(timeEscolhido)){
                verificacaoBasquete = true;
                decisao = confirmacao("Realmente deseja excluir esse clube? ");
                if (decisao == 1){
                    listaTimesBasquete.remove(time);
                    System.out.println("Time removido.");
                }
                break;
            }   
        }
        
        if (verificacaoBasquete == false && verificacaoFutebol == false){ // Verifica se o time faz parte de alguma das listas
            System.out.println("Esse time não está cadastrado.");
        }
    }
    
    public static int confirmacao(String frase){ // Função que imprime e recebe a opção do usuário para confirmar algo
        System.out.println("1| Sim");
        System.out.println("2| Não");
        return lerInt(frase);
    }
    
    public static void tipoListagem(String frase, ArrayList<TimeDeFutebol> listaTimesFutebol, ArrayList<TimeDeBasquete> listaTimesBasquete){ // Função que permite o usuário listar todos os objetos cadastrados em formato tabular ou apenas um deles através do seu nome
        System.out.println();
        System.out.println("1| Listar todos os times registrados");
        System.out.println("2| Listar todas as informações de um time através do seu nome");
        int decisao = lerInt(frase);
        
        if (decisao == 1){
            ArrayList<Time> timesGeral = new ArrayList<Time>(); // Criando uma nova lista para adicionar todos os times independente da modalidade

            for (TimeDeFutebol time : listaTimesFutebol){
                timesGeral.add(time);
            }
            for (TimeDeBasquete time : listaTimesBasquete){
                timesGeral.add(time);
            }
            
            listagemOrdenada(timesGeral);
            
            System.out.println();
            System.out.println("Nome | Cidade | Ano de Fundação");

            for (Time time : timesGeral){
                System.out.println(time.nome + " | " + time.cidade + " | " + time.anoFundacao);
            }
        } 
        else{
            String nomeTime = lerString("Digite o nome do time que você deseja ter todas informações: ");
            System.out.println();
            
            for (TimeDeFutebol time : listaTimesFutebol){
                if ((time.nome).equals(nomeTime)){
                    System.out.println("Nome | Cidade | Técnico | Ano de Fundação | Tamanho do Elenco | Modalidade | Capitão | Aproveitamento em casa");
                    System.out.println(time.nome + " | " + time.cidade + " | " + time.tecnico + " | " + time.anoFundacao + " | " + time.tamanhoElenco + " | " + time.modalidade + " | "  + time.capitao + " | "  + time.aproveitamentoCasa + "%");
                    break;
                }
            }
            for (TimeDeBasquete time : listaTimesBasquete){
                if ((time.nome).equals(nomeTime)){
                    System.out.println("Nome | Cidade | Técnico | Ano de Fundação | Tamanho do Elenco | Modalidade | Aproveitamento do time em TL | Média de altura dos jogadores");
                    System.out.println(time.nome + " | " + time.cidade + " | " + time.tecnico + " | " + time.anoFundacao + " | " + time.tamanhoElenco + " | " + time.modalidade + " | "  + time.aproveitamentoTiroLivre + "% | "  + time.mediaAltura);
                    break;
                }
            }
        }
    }

    public static void listagemOrdenada(ArrayList<Time> timesGeral){ // Função que ordena a lista enviada de acordo com o atributo desejado pelo usuário
        int resposta = 0;
        while(resposta < 1 || resposta > 3){
            System.out.println();    
            System.out.println("1| Nome");
            System.out.println("2| Cidade");
            System.out.println("3| Ano de fundação");
            resposta = lerInt("Digite por qual atributo você deseja ordenar a lista: ");
        }

        if(resposta == 1){
            timesGeral.sort(Comparator.comparing(Time::getNome));
        }
        else if(resposta == 2){
            timesGeral.sort(Comparator.comparing(Time::getCidade));
        }
        else{
            timesGeral.sort(Comparator.comparing(Time::getAnoFundacao));
        }
    }
    
    public static int lerInt(String texto){ // Função para receber valores inteiros do usuário
        boolean auxiliar = true;
        int recebido = 0;
        while(auxiliar){ 
            try{ // Tratamento de erro para caso o usuário insira um valor de outro tipo
                Scanner leitor = new Scanner(System.in); 
                System.out.print(texto);
                recebido = leitor.nextInt();
                auxiliar = false;}
            catch(InputMismatchException e){System.out.println("Opção inválida!");}}
        return recebido;
    }
    
    public static String lerString(String texto){ // Função para receber valores String do usuário
        Scanner leitor = new Scanner(System.in); 
        System.out.print(texto);
        return leitor.next();
    }
    
    public static double lerDouble(String texto){ // Função para receber valores double do usuário
        Scanner leitor = new Scanner(System.in);
        System.out.print(texto);
        return leitor.nextDouble();
    }
}

