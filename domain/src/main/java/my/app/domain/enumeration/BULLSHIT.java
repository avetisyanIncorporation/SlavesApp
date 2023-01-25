package my.app.domain.enumeration;

import java.util.Random;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public enum BULLSHIT {

    POOR(0),
    COOL(1),
    REAL(2);

    private final int id;

    BULLSHIT(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static BULLSHIT get(Random random) {
        BULLSHIT[] bullshits = values();
        return bullshits[random.nextInt(bullshits.length)];
    }

    public static BULLSHIT of(int id) {
        for (var bullshit : BULLSHIT.values()) {
            if (bullshit.getId() == id) {
                return bullshit;
            }
        }
        throw new IllegalArgumentException(String.format("Bullshit with id=%d doesn't exist", id));
    }
}
