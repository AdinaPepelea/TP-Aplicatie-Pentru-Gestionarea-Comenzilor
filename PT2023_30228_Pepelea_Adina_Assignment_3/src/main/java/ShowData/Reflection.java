package ShowData;

import Model.Client;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Aceasta clasa utilizeaza reflectia pentru a extrage campurile din lista de obiecte data ca parametru
 * @param <T>
 */

public class Reflection<T> {

    /**
     * Aceasta metoda extrage proprietatile obiectelor folosind reflectie
     * @param object
     */
    public static void retrieveProperties(Object object)
    {
        for(Field field: object.getClass().getDeclaredFields())
        {
            field.setAccessible(true);
            Object value;
            try{
                value=field.get(object);
                System.out.println(field.getName()+ "="+value);
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch(IllegalAccessException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Aceasta metoda returneaza numele fiecarei coloane dintr-un tabel.
     * @param object
     * @return
     */
    public  List<T> retrieveheader(List<T> object) {
        List<T> lista=new ArrayList<>();
        T obiect= object.get(0);
        for (Field field : obiect.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.getName();
                lista.add((T) value);

            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

        }
        return lista;
    }

}
