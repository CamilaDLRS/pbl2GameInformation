import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] scoreBoard = new String[5][5];
        scoreBoard[0][0] = "Nome";
        scoreBoard[0][1] = "Pontuação";
        scoreBoard[0][2] = "Moedas Lvl 1";
        scoreBoard[0][3] = "Moedas Lvl 2";
        scoreBoard[0][4] = "Moedas Lvl 3";

        System.out.printf("Olá, bem vindo ao painel do nosso jogo!\n");

        boolean loop = true;
        while (loop) {
            System.out.println(
                    "\nDigite o número de uma operação:\n" +
                    "1) Preecher painel\n" +
                    "2) Atualizar pontuação de um determinado jogador\n" +
                    "3) Mostrar pontuação de um jogador\n" +
                    "4) Mostrar total de moedas por nivel/jogador \n" +
                    "5) Mostrar jogador com maior pontuação\n" +
                    "6) Mostrar painel\n" +
                    "7) Sair");
            int escolha = scan.nextInt();
            int numJogador = 0;
            switch (escolha) {
                case 1 :
                    for (int i = 1; i < scoreBoard.length; i++) {
                        int aux = 0;

                        System.out.printf("\nNome %d° jogador: ", i);
                        scoreBoard[i][0] = scan.next();

                        System.out.print("Moedas Lvl 1:");
                        scoreBoard[i][2] =scan.next();
                        aux += Integer.parseInt(scoreBoard[i][2]);

                        System.out.print("Moedas Lvl 2:");
                        scoreBoard[i][3] =scan.next();
                        aux += Integer.parseInt(scoreBoard[i][3]);

                        System.out.print("Moedas Lvl 3:");
                        scoreBoard[i][4] =scan.next();
                        aux += Integer.parseInt(scoreBoard[i][4]);

                        scoreBoard[i][1] = String.valueOf(aux * 10);

                    }
                    break;
                case 2 :
                    if (scoreBoard[1][0] == null) {
                        System.out.println("Não há jogadores no painel.");
                        break;
                    }
                    System.out.print("Digite o número do jogador que deseja alterar: ");
                    numJogador = scan.nextInt();

                    if (scoreBoard[numJogador][0] == null) {
                        System.out.println("Esse jogador não existe.");
                        break;
                    }

                    System.out.printf("Pontuação atual é %s. Digite a nova pontuação: ", scoreBoard[numJogador][1]);
                    scoreBoard[numJogador][1] = String.valueOf(scan.nextInt());
                    break;
                case 3 :
                    if (scoreBoard[1][0] == null) {
                        System.out.println("Não há jogadores no painel.");
                        break;
                    }
                    System.out.print("Digite o número do jogador que deseja visualizar a pontuação: ");
                    numJogador = scan.nextInt();

                    if (scoreBoard[numJogador][0] == null) {
                        System.out.println("Esse jogador não existe.");
                        break;
                    }

                    System.out.printf("Pontuação atual é %s\n", scoreBoard[numJogador][1]);
                    break;
                case 4 :
                    if (scoreBoard[1][0] == null) {
                        System.out.println("Não há jogadores no painel.");
                        break;
                    }
                    System.out.print("Digite o numero do nivel: ");
                    int numlvl = scan.nextInt();
                    for (int i = 0; i < scoreBoard.length ; i++) {
                        System.out.printf("%-16s",scoreBoard[i][0] );
                        System.out.printf("%-16s \n",scoreBoard[i][1 + numlvl]);
                    }
                    break;
                case 5 :
                    if (scoreBoard[1][0] == null) {
                        System.out.println("Não há jogadores no painel.");
                        break;
                    }
                    numJogador = 1;
                    for (int i = 2; i < scoreBoard.length ; i++) {
                        if (Integer.parseInt(scoreBoard[i][1]) > Integer.parseInt(scoreBoard[numJogador][1])){
                            numJogador = i;
                        }
                    }
                    System.out.printf("O jogador %s tem a maior pontuação que é %s\n", scoreBoard[numJogador][0], scoreBoard[numJogador][1]);
                    break;
                case 6 :
                    if (scoreBoard[1][0] == null) {
                        System.out.println("Não há jogadores no painel.");
                        break;
                    }
                    for (int i = 0; i < scoreBoard.length; i++) {
                        for (int j = 0; j < scoreBoard[i].length; j++) {
                            System.out.printf("%-16s", scoreBoard[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 7 :
                    loop = false;
                    break;
                default :
                    System.out.println("Operação inválida.");
                    break;
            }
        }
    }
}