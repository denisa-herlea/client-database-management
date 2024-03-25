package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;


import javax.swing.table.DefaultTableModel;



public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * metoda care primeste rezultatul unei interogari sql si il transforma intr-o lista de obiecte
     * @param resultSet
     * @return
     */

    private ArrayList<T> createObjects(ResultSet resultSet) {

        ArrayList<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);

            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * metoda care creaza prin intermediul reflexiei tabelul pentru afisare
     * @param resultSet
     * @return
     */

    public DefaultTableModel createHeaderAndPopulate(ResultSet resultSet){
        ArrayList<T> objects = createObjects(resultSet);
        Vector<String> columns = new Vector<>();
        for(Field field : type.getDeclaredFields()){
            columns.add(field.getName());
        }
        Vector<Vector<String>> lines = new Vector<>();
        for(T o : objects){
            Vector<String> line = new Vector<>();
            for(Field field : type.getDeclaredFields()){
                String fieldName = field.getName();
                PropertyDescriptor propertyDescriptor = null;
                try {
                    propertyDescriptor = new PropertyDescriptor(fieldName, type);
                } catch (IntrospectionException e) {
                    e.printStackTrace();
                }
                Method method = propertyDescriptor.getReadMethod();
                try {
                    line.add(method.invoke(o).toString());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            lines.add(line);
        }
        return new DefaultTableModel(lines,columns);
    }

}
