package my.app.domain.enumeration;

import java.util.Random;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public enum Bullshit {

    POOR(1),
    COOL(2),
    REAL(3);

    private final int id;

    Bullshit(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Bullshit randomBullshit(Random random) {
        Bullshit[] bullshits = values();
        return bullshits[random.nextInt(bullshits.length)];
    }

    public static Bullshit of(int id) {
        for (var bullshit : Bullshit.values()) {
            if (bullshit.getId() == id) {
                return bullshit;
            }
        }
        throw new IllegalArgumentException(String.format("Bullshit with id=%d doesn't exist", id));
    }
}
