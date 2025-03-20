import javax.swing.JOptionPane;

public class ordenacao {

    public static void main(String[] args) {

        Pessoa[] Pessoa = new Pessoa[3];
        JOptionPane.showInternalMessageDialog(null, "Bem vindo!!");

        int escolha = Menu();

        switch (escolha) {
            case 1:
                Leitura(Pessoa);
                break;
            case 2:
                Imprimir(Pessoa);
                break;
            case 3:
                //BuscaSenha(lista);
                break;
            case 4:
                //ClassificarNome(lista);
                break;
            case 5:
                //ClassificarSenha(lista);
                break;
            case 6:
                //BuscaSenha(lista);
                break;
            case 7:
                //ClassificarNome(lista);
                break;
            case 8:
                //ClassificarSenha(lista);
                break;
            default:
                JOptionPane.showMessageDialog(null, ("OBRIGADO POR USAR O SISTEMA!"));
        }

    }

    public static void Leitura(Pessoa[] lista) {

        //Laço para preencher o vetor
        for (int i = 0; i < lista.length; i++) {


            //Instanciando um objeto Usuario em cada posição
            lista[i] = new Pessoa();

            //Solicitando o nome do usuario
            String nome = JOptionPane.showInputDialog(null, "Digite o nome");
            lista[i].setNome(nome);

            String email = JOptionPane.showInputDialog(null, "Digite o email");
            lista[i].setEmail(email);

            String rg = JOptionPane.showInputDialog(null, "Digite o rg");
            lista[i].setRg(rg);

        }
    }

    public static void Imprimir(Pessoa[] Pessoa) {

        for (int i = 0; i < Pessoa.length; i++) {

            JOptionPane.showMessageDialog(null, "Nome: " + Pessoa[i].getNome() + " Email: " + Pessoa[i].getEmail() + " RG: " + Pessoa[i].getEmail());
        }
    }

    public static int Menu() {

        //Opções do Menu
        String[] opcoes = {
                "Ler Nome, Email e RG",
                "Exibir tudo lado a lado",
                "Buscar Senha",
                "Classificar por Nome - Selection Sort",
                "Classificar por Nome - Insert Sort",
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

}

