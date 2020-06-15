package lesson7.hiber;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class HiberCore {

    Connection con;
    Statement stmt;

    public void init() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:hiberDB");
        stmt = con.createStatement();
    }

    public void processComponents(Class<?> cl) throws ClassNotFoundException, SQLException {
        init();
        if (cl.isAnnotationPresent(HiberTable.class)) {
            String tableName = cl.getAnnotation(HiberTable.class).tableName();
            Field [] fields = cl.getDeclaredFields();
            StringBuilder sqlCreateQuery = new StringBuilder();
            sqlCreateQuery.append("CREATE TABLE IF NOT EXISTS ").append(tableName).append("(");
            for (Field field : fields) {
                String fieldName = field.getAnnotation(HiberField.class).fieldName();
                String type = field.getAnnotation(HiberField.class).sqlType();
                sqlCreateQuery.append(fieldName).append(' ').append(type).append(", ");
            }
            sqlCreateQuery.delete(sqlCreateQuery.length()-2, sqlCreateQuery.length()).append(");");
            System.out.println(sqlCreateQuery);
            stmt.execute(sqlCreateQuery.toString());
        }
    }

    public Object getObject(Class<?> cl, int id) throws SQLException, NoSuchMethodException {
        // TODO: 6/15/2020
        String tableName = cl.getAnnotation(HiberTable.class).tableName();
        ArrayList<Class<?>> params = new ArrayList<>();
        for (Field field : cl.getDeclaredFields()) {
            if (field.isAnnotationPresent(HiberField.class)) {
                Class<?> clazz = field.getType();
                params.add(clazz);
            }
        }
        //select * from tableName where id = ?
        String query = "select * from " + tableName + " where id = " + id + ";";
        ResultSet rs = stmt.executeQuery(query);
        Object result = null;
        while (rs.next()) {
            Class [] cla = new Class[params.size()];

            //Object instanse = cl.getConstructor(params.toArray(cla)).newInstance();
            //result = instanse;
        }
        return result;
    }

    public Object convertJavaStringToSQL(Object object) {
        if (object instanceof String) {
            String s = (String) object;
            s = "'" + s + "'";
            return s;
        }
        return object;
    }

    public void insertObject(Object object) throws IllegalAccessException, SQLException {
        // TODO: 6/15/2020
        Class<?> cl = object.getClass();
        String tableName = cl.getAnnotation(HiberTable.class).tableName();
        StringBuilder insertQuery = new StringBuilder();
        insertQuery.append("insert into ").append(tableName).append(" values(");
        for (Field field : cl.getDeclaredFields()) {
            if (field.isAnnotationPresent(HiberField.class)) {
                Object value = convertJavaStringToSQL(field.get(object));
                insertQuery.append(value).append(", ");
            }
        }
        insertQuery.delete(insertQuery.length()-2, insertQuery.length()).append(");");
        stmt.executeUpdate(insertQuery.toString());
        //insert into tableName values('a', 1, 12);
    }
}
