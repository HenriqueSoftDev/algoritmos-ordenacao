import javax.swing.JOptionPane;

public class ordenacao {

    public static void main(String[] args) {

        Pessoa[] Pessoa = new Pessoa[3];
        JOptionPane.showInternalMessageDialog(null, "Bem vindo!!");

        Leitura(Pessoa);

        int escolha = Menu();

        switch (escolha) {
            case 1:
                //Exibir Informações
                Imprimir(Pessoa);
                break;
            case 2:
                //Selection Sort (Nome);
                selectionSortNome(Pessoa);
                break;
            case 3:
                //Insertion Sort (Nome)
                insertionSortNome(Pessoa);
                break;
            case 4:
                //Selection Sort (Rg)
                selectionSortRg(Pessoa);
                break;
            case 5:
                //Insertion Sort (Rg)
                insertionSortRg(Pessoa);
                break;
            case 6:
                //Busca Binária (Rg)

                break;
            case 7:
                //Busca Binária (Nome)
                break;
            case 8:
                //Quick Sort (E-mail)
                break;
            case 9:
                //MegaSort (Rg)
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
                "Exibir Informações",
                "Selection Sort (Nome)",
                "Insertion Sort (Nome)",
                "Selection Sort (Rg)",
                "Insertion Sort (Rg)",
                "Busca Binária (Rg)",
                "Busca Binária (Nome)",
                "Quick Sort (E-mail)",
                "Mega Sort (Rg)"};

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

    public static void insertionSortNome(Pessoa[] pessoa) {
        //variáveis usadas para comparar os valores
        Pessoa key = new Pessoa();
        int j;

        //key recebe o valor da segunda posição e j da posição anterior (primeira)
        for (int i = 1; i < pessoa.length; i++) {
            key = pessoa[i];
            j = i - 1;

            //Condicional que troca os valores da posição atual com anterior caso necessário
            while (j >= 0 && pessoa[j].nome.compareTo(key.nome) > 0) {
                pessoa[j + 1] = pessoa[j];
                j = j - 1;
            }

            pessoa[j + 1] = key;
        }

        //Laços para imprimir os Nomes
        for (int i = 0; i < pessoa.length; i++) {
            JOptionPane.showMessageDialog(null, "Nome: " + pessoa[i].getNome());
        }
    }

    public static void insertionSortRg(Pessoa[] pessoa) {

        //Padroniza a quantidade de caracteres para 8
        for (int i = 0; i < pessoa.length; i++) {
            pessoa[i].rg = String.format("%08d", Integer.parseInt(pessoa[i].rg));
        }

        //variáveis usadas para comparar os valores
        Pessoa key = new Pessoa();
        int j;

        //Key recebe o valor da segunda posição e j da posição anterior (primeira)
        for (int i = 1; i < pessoa.length; i++) {
            key = pessoa[i];
            j = i - 1;

            //Condicional que troca os valores da posição atual com anterior caso necessário
            while (j >= 0 && pessoa[j].rg.compareTo(key.rg) > 0) {
                pessoa[j + 1] = pessoa[j];
                j = j - 1;
            }

            pessoa[j + 1] = key;
        }

        //Laço para imprimir os Rgs
        for (int i = 0; i < pessoa.length; i++) {
            JOptionPane.showMessageDialog(null, "Rg: " + pessoa[i].getRg());
        }
    }

    //Função usada na função selectionSortNome
    public static int menorValorNome(Pessoa[] pessoa, int i) {

        //Variável para guardar posição do menor valor (consideramos o primeiro valor como o menor)
        int k = i;

        //Laço que percorre as posições adiante do i
        for (int j = i + 1; j < pessoa.length; j++) {

            //Condicional que guarda o número da posição com o menor valor
            if (pessoa[j].nome.compareTo(pessoa[k].nome) < 0) {
                k = j;
            }
        }
        return k;
    }

    public static void selectionSortNome(Pessoa[] pessoa) {
        for (int i = 0; i < pessoa.length; i++) {

            //Variavel pra guardar a posição do menor elemento
            int m = menorValorNome(pessoa, i);

            //Trocando as posições dos objetos
            Pessoa n = new Pessoa();
            n = pessoa[i];
            pessoa[i] = pessoa[m];
            pessoa[m] = n;

        }
        for (int i = 0; i < pessoa.length; i++) {

            //Laço para imprimir os Nomes
            JOptionPane.showMessageDialog(null, "Nome: " + pessoa[i].getNome());
        }
    }

    public static int menorValorRg(Pessoa[] pessoa, int i) {

        //Variável para guardar posição do menor valor (consideramos o primeiro valor como o menor)
        int k = i;

        //Laço que percorre as posições adiante do i
        for (int j = i + 1; j < pessoa.length; j++) {

            //Condicional que guarda o número da posição com o menor valor
            if (pessoa[j].rg.compareTo(pessoa[k].rg) > 0) {
                k = j;
            }
        }
        return k;
    }

    public static void selectionSortRg(Pessoa[] pessoa) {

        //Padroniza a quantidade de números para 8
        for (int i = 0; i < pessoa.length; i++) {
            pessoa[i].rg = String.format("%08d", Integer.parseInt(pessoa[i].rg));
        }

        for (int i = 0; i < pessoa.length; i++) {

            //Variavel pra guardar a posição do menor elemento
            int m = menorValorRg(pessoa, i);

            //Trocando as posições dos objetos
            Pessoa n = new Pessoa();
            n = pessoa[i];
            pessoa[i] = pessoa[m];
            pessoa[m] = n;

        }

        //Laço para imprimir os Rgs
        for (int i = 0; i < pessoa.length; i++) {
            JOptionPane.showMessageDialog(null, "Rg: " + pessoa[i].getRg());
        }
    }

}

