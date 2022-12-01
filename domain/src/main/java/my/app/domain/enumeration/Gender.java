package my.app.domain.enumeration;

import java.util.Random;

/**
 * @author created by Pargev A. on 18.11.2022
 */
public enum Gender {

    MAN,
    WOMAN;

    public static Gender randomGender(Random random)  {
        Gender[] genders = values();
        return genders[random.nextInt(genders.length)];
    }

}
