package blackjack;

import java.util.ArrayList;
import java.util.Random;

public class KortuMalka extends Dileris {

    public void naujaKortuMalka() {
        for (int i = 2; i <= 11; i++) {
            if (i < 10 || i == 11) {
                for (int j = 0; j < 4; j++) {
                    kortos.add(i);
                }
            } else {
                for (int j = 0; j < 16; j++) {
                    kortos.add(i);
                }
            }
        }
    }

    public void kortuMaisymas() {
        ArrayList<Integer> nkortos = new ArrayList<Integer>();
        Random random = new Random();
        int index;
        int size = kortos.size();
        for (int i = 0; i < size; i++) {
            index = random.nextInt(kortos.size());
            nkortos.add(kortos.get(index));
            kortos.remove(index);
        }
        kortos = nkortos;
    }

    public ArrayList<Integer> getKortos() {
        return kortos;
    }
    
}
