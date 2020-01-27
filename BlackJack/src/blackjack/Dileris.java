package blackjack;

import java.util.ArrayList;

public class Dileris {

    protected ArrayList<Integer> kortos = new ArrayList<Integer>();
    int taskai;

    public Dileris() {
        taskai = 0;
    }

    public void addKorta(int korta) {
        taskai += korta;
        kortos.add(korta);
    }

    public int pasiimtiKorta() {
        int k = kortos.get(0);
        kortos.remove(0);
        taskai -= k;
        return k;
    }

    public int getTaskai() {
        return taskai;
    }

    public void setTaskai(int taskai) {
        this.taskai = taskai;
    }

}
