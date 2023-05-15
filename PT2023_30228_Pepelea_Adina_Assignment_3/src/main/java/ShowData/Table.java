package ShowData;

import Presentation.ViewClient;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * In aceasta clasa se creeaza o fereastra noua in care sunt afisate tabelele, in functie de alegere: Client, Order
 * sau Product.
 * @param <T>
 */
public class Table<T> extends JFrame{
    public JFrame frame;
    public JTable tabel;
    public JScrollPane scroll;

    /**
     * Constructorul va crea un tabel cu fiecare celula din baza de date.
     * @param lista
     * @throws IllegalAccessException
     * @throws NoSuchFieldException
     */
    public Table(List<T> lista) throws IllegalAccessException, NoSuchFieldException {
        setTitle("TABEL" + lista.get(0).getClass().getName());
        frame = new JFrame();
        Reflection<T> ref=new Reflection<T>();

        int nrColoane=ref.retrieveheader(lista).size();
        String[] coloana=new String[nrColoane];
        for(int i=0; i<nrColoane;i++)
        {
            coloana[i]=ref.retrieveheader(lista).get(i).toString();
        }

        int nrLinii=lista.size();
        String[][] celulaTabel=new String[nrLinii][nrColoane];

        int linie=0, col;
        for(T t: lista)
        {
            col=0;
            for(Field field : t.getClass().getDeclaredFields())
            {
                field.setAccessible(true);
                Object value=field.get(t);
                celulaTabel[linie][col]=value.toString();
                col++;
            }
            linie++;
        }
        tabel=new JTable(celulaTabel,coloana);
        tabel.setBounds(100,100,400,400);
        scroll=new JScrollPane(tabel);
        frame.add(scroll);
        frame.setSize(500,200);
        frame.setVisible(true);

    }

}
