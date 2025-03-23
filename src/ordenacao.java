import javax.swing.JOptionPane;

public class ordenacao {

    public static void main(String[] args) {

        Pessoa[] Pessoa = new Pessoa[3];
        JOptionPane.showInternalMessageDialog(null, "Bem vindo!!");

        Leitura(Pessoa);

        // A caixa de menu está com muitas opções, ultrapassando o limite da tela
        int escolha = Menu();

        switch (escolha) {
            case 1:
                Imprimir(Pessoa);
                break;
            case 2:
                //BuscaSenha(lista);
                break;
            case 3:
                //ClassificarNome(lista);
                break;
            case 4:
                //ClassificarSenha(lista);
                insertionSort(Pessoa);
                break;
            case 5:
                //BuscaSenha(lista);
                break;
            case 6:
                //ClassificarNome(lista);
                break;
            case 7:
                //ClassificarSenha(lista);
                break;
            default:
                JOptionPane.showMessageDialog(null, ("OBRIGADO POR USAR O SISTEMA!"));
        }

    }

    public static Pessoa[] Leitura(Pessoa[] pessoa) {

        //Laço para preencher o vetor
        for (int i = 0; i < pessoa.length; i++) {


            //Instanciando um objeto Usuario em cada posição
            pessoa[i] = new Pessoa();

            //Solicitando o nome do usuario
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            pessoa[i].setNome(nome);

            String email = JOptionPane.showInputDialog(null, "Digite o email");
            pessoa[i].setEmail(email);

            String rg = JOptionPane.showInputDialog(null, "Digite o rg");
            pessoa[i].setRg(rg);

        }
        return pessoa;
    }

    public static void Imprimir(Pessoa[] Pessoa) {

        for (int i = 0; i < Pessoa.length; i++) {

            JOptionPane.showMessageDialog(null, "Nome: " + Pessoa[i].getNome() + " Email: " + Pessoa[i].getEmail() + " RG: " + Pessoa[i].getEmail());
        }
    }

    public static int Menu() {

        //Opções do Menu
        String[] opcoes = {
                "Exibir tudo lado a lado",
                "Buscar Senha",
                "Classificar por Nome - Selection Sort",
                "Classificar por Nome - Insertion Sort",
                "Classificar por RG - Selection Sort",
                "Classificar por RG usando Insert Sort",
                "Buscar um RG usando busca binária",
                "buscar um nome usando busca binária",
                "finalizar programa"};

        int escolha = JOptionPane.showOptionDialog(null,
                "Escolha uma opção:",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                opcoes,
                opcoes[0]);

        return escolha + 1;
    }

    public static void insertionSort (Pessoa[] pessoa){
        //variáveis usadas para comparar os valores
        Pessoa key = new Pessoa();
        int j;

        //key recebe o valor da segunda posição e j da posição anterior (primeira)
        for (int i = 1; i < pessoa.length; i++){
            key = pessoa[i];
            j = i - 1;

            //Condicional que troca os valores da posição atual com anterior caso necessário
            while (j >= 0 && pessoa[j].nome.compareTo(key.nome) > 0){
            pessoa[j+1] = pessoa[j];
            j = j-1;
            }

            pessoa[j+1] = key;
        }
        for (int i = 0; i < pessoa.length; i++){
            JOptionPane.showMessageDialog(null, "Nome: "+pessoa[i].getNome());
        }
    }

}

