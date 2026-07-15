


import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void mostrarMenu(Personagem jogador) {
        System.out.println("===== TURNO DA " + jogador.getNome() + " =====");
        System.out.println("1 - Atacar");
        System.out.println("2 - Defender");
        System.out.println("3 - Curar");
        System.out.print("Escolha: ");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int menu = 0;

        while (menu != 2) {

            System.out.println("====================");
            System.out.println("⚔️ BATTLE ⚔️");
            System.out.println("====================");
            System.out.println("1 - Jogar");
            System.out.println("2 - Sair");
            System.out.print("Escolha: ");

            menu = teclado.nextInt();

            switch (menu) {

                case 1:
                    Personagem honoka = new Personagem("Honoka", 100, "Soco", 20);
                    Personagem marie = new Personagem("Marie", 100, "chute", 15);
                    Personagem[] lutadores = {honoka, marie};
                    System.out.println("\nEscolha seu lutador:");
                    for (int i = 0; i < lutadores.length; i++) {
                        System.out.println(i + 1 + " - " + lutadores[i].getNome());
                    }
                    System.out.print("Escolha: ");
                    int escolha = teclado.nextInt();
                    Personagem jogador = lutadores[escolha - 1];
                    Personagem inimigo;

                    if (jogador == honoka) {
                        inimigo = marie;
                    } else {
                        inimigo = honoka;
                    }
                    System.out.println("Você escolheu: " + jogador.getNome());
                    Random random = new Random();
                    System.out.println("========================");
                    System.out.println("⚔️ BATALHA INICIADA!");
                    System.out.println("========================");
                    while (jogador.getHp() > 0 && inimigo.getHp() > 0) {
                        jogador.barraVida();
                        inimigo.barraVida();
                        mostrarMenu(jogador);
                        int opcao = teclado.nextInt();

                        switch (opcao) {
                            case 1:
                                jogador.atacar(inimigo);
                                break;
                            case 2:
                                jogador.defender();
                                break;
                            case 3:
                                jogador.curar();
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;

                        }

                        if (inimigo.getHp() > 0) {
                            int escolhaIA = random.nextInt(3);
                            System.out.println("\n===== TURNO DA " + inimigo.getNome() + " =====");
                            switch (escolhaIA) {

                                case 0:
                                    inimigo.atacar(jogador);
                                    break;

                                case 1:
                                    inimigo.defender();
                                    break;

                                case 2:
                                    inimigo.curar();
                                    break;
                            }

                            jogador.barraVida();
                            inimigo.barraVida();


                            teclado.nextLine();
                            System.out.println("\nPressione ENTER para continuar...");
                            teclado.nextLine();
                        }


                    }
                    if (jogador.getHp() > 0) {
                        System.out.println("🏆 " + jogador.getNome() + " venceu!");
                    } else {
                        System.out.println("💀 " + inimigo.getNome() + " venceu!");
                    }

                    teclado.nextLine();
                    System.out.println("\nPressione ENTER para voltar ao menu...");
                    teclado.nextLine();
                    break;

                case 2:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } teclado.close();
    }
}

