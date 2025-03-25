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
                String rg = JOptionPane.showInputDialog("Digite o RG que deseja encontrar:");
                buscaBinariaRg(Pessoa, rg);
                break;
            case 7:
                //Busca Binária (Nome)
                String nome = JOptionPane.showInputDialog("Digite o Nome que deseja encontrar:");
                buscaBinariaNome(Pessoa,nome);
                break;
            case 8:
                //Quick Sort (E-mail)
                quickSortEmail(Pessoa, 0, Pessoa.length);
                Imprimir(Pessoa);
                break;
            case 9:
                //MegaSort (Rg)
                mergeSort(Pessoa, 0, Pessoa.length - 1);
                Imprimir(Pessoa);
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

            String rg = JOptionPane.showInputDialog(null, "Digite o rg (8 números)");
            pessoa[i].setRg(rg);

        }
        return pessoa;
    }

    public static void Imprimir(Pessoa[] Pessoa) {

        for (int i = 0; i < Pessoa.length; i++) {

            JOptionPane.showMessageDialog(null, "Nome: " + Pessoa[i].getNome() + " \nEmail: " + Pessoa[i].getEmail() + " \nRG: " + Pessoa[i].getRg());
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
                "Mega Sort (Rg)",
                "Finalizar"};

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

            //Variavel para guardar a posição do menor elemento
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
            if (pessoa[j].rg.compareTo(pessoa[k].rg) < 0) {
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

            //Variavel para guardar a posição do menor elemento
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

    public static void buscaBinariaRg(Pessoa[] pessoa, String rg) {

        // Aqui ordeno o meu array, antes de efetuar a busca
        insertionSortRg(pessoa);

        int inicio = 0;
        int fim = pessoa.length - 1;
        boolean encontrado = false;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (pessoa[meio].getRg().equals(rg)) {
                JOptionPane.showMessageDialog(null, "RG encontrado: " + pessoa[meio].getRg() +
                        "\nNome: " + pessoa[meio].getNome() +
                        "\nEmail: " + pessoa[meio].getEmail());
                encontrado = true;
                break;
            }
            else if (pessoa[meio].getRg().compareTo(rg) < 0) {
                inicio = meio + 1;
            }
            else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "RG não encontrado.");
        }
    }
    public static void buscaBinariaNome(Pessoa[] pessoa, String nome){

        // Aqui ordeno o meu array, antes de efetuar a busca
        insertionSortNome(pessoa);

        int inicio = 0;
        int fim = pessoa.length - 1;
        boolean encontrado = false;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (pessoa[meio].getNome().equalsIgnoreCase(nome)) {
                JOptionPane.showMessageDialog(null, "Nome encontrado: " + pessoa[meio].getNome() +
                        "\nRG: " + pessoa[meio].getRg() +
                        "\nEmail: " + pessoa[meio].getEmail());
                encontrado = true;
                break;
            }
            else if (pessoa[meio].getNome().compareToIgnoreCase(nome) < 0) {
                inicio = meio + 1;
            }
            else {
                fim = meio - 1;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "Nome não encontrado.");
        }
    }

    public static void quickSortEmail(Pessoa[] pessoa, int esq, int dir) {
        
        int i = esq;
        int j = dir - 1;
        //Define o pivô(Elemento do meio)
        Pessoa pivo = pessoa[(esq + dir) / 2];

        while (i <= j) {
            // Encontra um elemento maior ou igual ao pivô da esquerda
            while (pessoa[i].getEmail().compareToIgnoreCase(pivo.getEmail()) < 0 && i < dir) {
                i++;
            }
            // Encontra um elemento menor ou igual ao pivô da direita
            while (pessoa[j].getEmail().compareToIgnoreCase(pivo.getEmail()) > 0 && j > esq) {
                j--;
            }
            if (i <= j) {
                // Troca pessoa[i] e pessoa[j]
                Pessoa aux = pessoa[i];
                pessoa[i] = pessoa[j];
                pessoa[j] = aux;
                i++;
                j--;
            }
        }
        if (j > esq) {
            quickSortEmail(pessoa, esq, j + 1);
        }
        if (i < dir) {
            quickSortEmail(pessoa, i, dir);
        }
    }

    public static void mergeSort(Pessoa[] pessoa, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // Divide e ordena as duas metades
            mergeSort(pessoa, left, middle);
            mergeSort(pessoa, middle + 1, right);

            // Combino as duas metades ordenadas
            merge(pessoa, left, middle, right);
        }
    }

    public static void merge(Pessoa[] pessoa, int left, int middle, int right) {

        // Crio um array auxiliar
        Pessoa[] helper = new Pessoa[pessoa.length];
        for (int i = left; i <= right; i++) {
            helper[i] = pessoa[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        // Combina as duas metades ordenadas
        while (i <= middle && j <= right) {
            if (helper[i].getRg().compareTo(helper[j].getRg()) <= 0) {
                pessoa[k] = helper[i];
                i++;
            } else {
                pessoa[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copia os elementos restantes
        while (i <= middle) {
            pessoa[k] = helper[i];
            i++;
            k++;
        }
    }
}

