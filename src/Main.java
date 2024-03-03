import java.util.Scanner;
public class Main {
    private static  Scanner scan = new Scanner(System.in);
    private static final int numeroJogadores = 5;
    private static  String[][] placar = new String[numeroJogadores][5];

     static {
         placar[0][0] = "Nome";
         placar[0][1] = "Pontuação";
         placar[0][2] = "Moedas Lvl 1";
         placar[0][3] = "Moedas Lvl 2";
         placar[0][4] = "Moedas Lvl 3";
     }

    public static void main(String[] args) {

        System.out.printf("Olá, bem vindo ao sistema de painel do nosso jogo!\n" +
                "Primeiramente, preecha o painel:\n");
        criarPainel();

        boolean sistemaLigado = true;
        while (sistemaLigado) {
            System.out.println(
                    "\nDigite o número de uma operação:\n" +
                    "1) Atualizar pontuação de um determinado jogador\n" +
                    "2) Mostrar pontuação de um jogador\n" +
                    "3) Mostrar total de moedas por nivel/jogador \n" +
                    "4) Mostrar jogador com maior pontuação\n" +
                    "5) Mostrar painel\n" +
                    "6) Sair");
            int operacaoEscolhida = scan.nextInt();

            switch (operacaoEscolhida) {
                case 1 :
                    atualizarPontuacaoJogador();
                    break;
                case 2 :
                    lerPontuacaoJogador();
                    break;
                case 3 :
                    lerMoedasPorNivelEJogador();
                    break;
                case 4 :
                    lerJogadorComMaiorPontuacao();
                    break;
                case 5 :
                    lerPainer();
                    break;
                case 6 :
                    sistemaLigado = false;
                    break;
                default :
                    System.out.println("Operação inválida.");
                    break;
            }
        }
        scan.close();
    }
    public static void criarPainel() {
        for (int i = 1; i < placar.length; i++) {
            int aux = 0;

            System.out.printf("\nNome %d° jogador: ", i);
            placar[i][0] = scan.next();

            System.out.print("Moedas Lvl 1:");
            placar[i][2] =scan.next();
            aux += Integer.parseInt(placar[i][2]);

            System.out.print("Moedas Lvl 2:");
            placar[i][3] =scan.next();
            aux += Integer.parseInt(placar[i][3]);

            System.out.print("Moedas Lvl 3:");
            placar[i][4] =scan.next();
            aux += Integer.parseInt(placar[i][4]);

            placar[i][1] = String.valueOf(aux * 10);
        }
    }
    public static void atualizarPontuacaoJogador() {
        System.out.println("Digite o número do jogador que deseja alterar: ");
        int numJogador = scan.nextInt();

        if (numJogador < 1 || numJogador >= numeroJogadores) {
            System.out.println("Número de jogador inválido.");
            return;
        }

        System.out.printf("Pontuação atual é %s. Digite a nova pontuação: ", placar[numJogador][1]);
        placar[numJogador][1] = String.valueOf(scan.nextInt());
    }
    public static void lerPontuacaoJogador() {
        System.out.println("Digite o número do jogador que deseja visualizar a pontuação: ");
        int numJogador = scan.nextInt();

        if (numJogador < 1 || numJogador >= numeroJogadores) {
            System.out.println("Número de jogador inválido.");
            return;
        }

        System.out.printf("Pontuação atual é %s\n", placar[numJogador][1]);
    }
    public static void lerMoedasPorNivelEJogador() {
        System.out.print("Digite o numero do nivel: ");
        int nivel = scan.nextInt();

        for (int i = 0; i < placar.length ; i++) {
            System.out.printf("%-16s",placar[i][0] );
            System.out.printf("%-16s \n",placar[i][1 + nivel]);
        }
    }
    public static void lerJogadorComMaiorPontuacao() {
        int numJogador = 1;
        for (int i = 2; i < placar.length ; i++) {
            if (Integer.parseInt(placar[i][1]) > Integer.parseInt(placar[numJogador][1])){
                numJogador = i;
            }
        }
        System.out.printf("O jogador %s tem a maior pontuação que é %s\n", placar[numJogador][0], placar[numJogador][1]);

        //TODO: verificar empate
    }
    public static void lerPainer() {
        for (int i = 0; i < placar.length; i++) {
            for (int j = 0; j < placar[i].length; j++) {
                System.out.printf("%-16s", placar[i][j]);
            }
            System.out.println();
        }
    }
}