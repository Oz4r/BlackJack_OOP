package blackjack;

import java.util.Scanner;

public class Game {

    KortuMalka kortuMalka = new KortuMalka();
    Losejas losejas = new Losejas();
    Dileris dileris = new Dileris();
    Scanner klaviatura = new Scanner(System.in);
    boolean clientHasMoney = true;
    boolean raundoPabaiga;
    boolean blackJack;

    public void gameStart() {

        kortuMalka.naujaKortuMalka();
        kortuMalka.kortuMaisymas();
        

        while (clientHasMoney) {
            try {
                if (losejas.pinigai == 0) {
                    System.out.println("Jus neturite daugiau pinigu. Viso geriausio!");
                    clientHasMoney = false;
                    break;
                }
                System.out.println("Jus turite: " + losejas.pinigai + "€");
                System.out.println("Jusu statymas: ");
                int losejoStatymas = klaviatura.nextInt();
                if (losejoStatymas > losejas.pinigai) {
                    System.out.println("Jus neturite tiek pinigu");
                    continue;
                }
                if (losejoStatymas == 0) {
                    System.out.println("Aciu uz zaidima!");
                    clientHasMoney = false;
                    break;
                }

                boolean raundoPabaiga = false;
                boolean blackJack = false;

                firstCardReceival();

                if (losejas.taskai == 21) {
                    System.out.println("BlackJack");
                    blackJack = true;
                } else {
                    while (true) {
                        System.out.println("Jus turite: " + losejas.taskai + " tasku");
                        System.out.println("Duoti korta? (1-taip, 2-ne)");
                        int choice;
                        choice = klaviatura.nextInt();
                        if (choice == 1) {
                            losejas.addKorta(kortuMalka.pasiimtiKorta());
                            if (losejas.taskai > 21) {
                                System.out.println("Jus pralaimejote, nes turite " + losejas.taskai + " tasku");
                                losejas.pralaimejo(losejoStatymas);
                                raundoPabaiga = true;
                                break;
                            }
                            if (losejas.taskai == 21) {
                                System.out.println("BlackJack");
                                blackJack = true;
                                break;
                            }
                        }
                        if (choice == 2) {
                            break;
                        }
                    }
                }

                dealerDraws();
                getDealersPoints();

                if (dileris.taskai > 21 && raundoPabaiga == false) {
                    System.out.println("Jus laimejote");
                    if (blackJack == true) {
                        losejas.laimejo(losejoStatymas * 1.5f);
                    } else {
                        losejas.laimejo(losejoStatymas);
                    }
                    raundoPabaiga = true;
                }
                if (dileris.taskai > losejas.taskai && raundoPabaiga == false) {
                    System.out.println("Jus pralaimejote");
                    losejas.pralaimejo(losejoStatymas);
                    raundoPabaiga = true;
                }
                if (losejas.taskai > dileris.taskai && raundoPabaiga == false) {
                    System.out.println("Jus laimejote");
                    if (blackJack == true) {
                        losejas.laimejo(losejoStatymas * 1.5f);
                    } else {
                        losejas.laimejo(losejoStatymas);
                    }
                    raundoPabaiga = true;
                }
                tie();
                cardRetrieval();
            } catch (Exception e) {
                System.out.println("Ivyko klaida!");
                break;
            }
        }
    }
    
    public void dealerDraws() {
        while (dileris.taskai <= 16) {
            dileris.addKorta(kortuMalka.pasiimtiKorta());
        }
    }

    public void getDealersPoints() {
        if (raundoPabaiga == false) {
            System.out.println("Dileris turi " + dileris.taskai + " tasku");
        }
    }

    public void tie() {
        if (losejas.taskai == dileris.taskai && raundoPabaiga == false) {
            System.out.println("Lygiosios");
        }
    }

    public void cardRetrieval() {
        while (losejas.taskai > 0) {
            kortuMalka.addKorta(losejas.pasiimtiKorta());
        }
        while (dileris.taskai > 0) {
            kortuMalka.addKorta(dileris.pasiimtiKorta());
        }
    }

    public void firstCardReceival() {
        for (int i = 0; i < 2; i++) {
            losejas.addKorta(kortuMalka.pasiimtiKorta());
            dileris.addKorta(kortuMalka.pasiimtiKorta());
        }
    }
}
