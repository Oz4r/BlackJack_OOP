package blackjack;

public class Losejas extends Dileris {

    protected float pinigai;

    protected Losejas() {
        pinigai = 500f;
    }

    public float getPinigai() {
        return pinigai;
    }

    public void setPinigai(float pinigai) {
        this.pinigai = pinigai;
    }

    public void pralaimejo(float num) {
        pinigai -= num;
    }

    public void laimejo(float num) {
        pinigai += num;
    }

}
