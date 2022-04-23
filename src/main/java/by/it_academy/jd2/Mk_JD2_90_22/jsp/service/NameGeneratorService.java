package by.it_academy.jd2.Mk_JD2_90_22.jsp.service;

import java.util.Random;

public class NameGeneratorService {
    public static String getRandomName(){
        String[] names = {
                "Илья", "Антон", "Иван"
        };

        Random rnd = new Random();

        return names[rnd.nextInt(names.length)];
    }
}
