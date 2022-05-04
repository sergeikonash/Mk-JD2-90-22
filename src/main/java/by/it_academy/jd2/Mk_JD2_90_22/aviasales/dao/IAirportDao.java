package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.util.List;

public interface IAirportDao<T> extends AutoCloseable {
    /**
     * Получить все аэропорты
     * @return
     */
    List<T> getAll();

    /**
     * Получить аэропорт
     * @param code код аэропорта
     * @return
     */
    T get(String code);
}
