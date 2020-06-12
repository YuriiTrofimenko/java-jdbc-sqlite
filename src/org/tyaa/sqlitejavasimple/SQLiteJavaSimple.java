/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tyaa.sqlitejavasimple;
import java.sql.*;

/**
 *
 * @author Yurii
 */
public class SQLiteJavaSimple {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //Соединение
        Connection connection = null;
        //Ответ из РБД
        ResultSet resultSet = null;
        //Запрос
        Statement statement = null;
               
        try
        {
            //Подключаем драйвер нужного типа
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:sqlite.db");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients ORDER BY id DESC");
            //boolean result =
                //statement.execute("INSERT INTO Clients ('Familiya', 'Imya', 'Otchestvo', 'Adress', 'Phone', 'Email') VALUES ('F1', 'I1', 'O1', 'A1', 911, 'E1')");
            //System.out.println(result);
            // resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type ='table' AND name NOT LIKE 'sqlite_%';");
            /* while(resultSet.next())
            {
                System.out.print(resultSet.getString("name"));
                System.out.println();
            } */
            /*
            *   Clients
                Zivotnoe
                Pol
                IstoriaObsledovaniya
                Vrach
            * */
            /*
            *   id - INTEGER
                record_count - INTEGER
                Familiya - TEXT
                Imya - TEXT
                Otchestvo - TEXT
                Adress - TEXT
                Phone - INTEGER
                Email - TEXT
            * */
            //
            /* for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.println(
                        resultSet.getMetaData().getColumnName(i)
                                + " - "
                                + resultSet.getMetaData().getColumnTypeName(i)
                );
            } */
            /* while(resultSet.next())
            {
                 System.out.print(resultSet.getString(1) + "\t" + resultSet.getString(3) + "\t");
                 // System.out.print(resultSet.getString("Adress") + "\t");
                 System.out.println();
            } */
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                if (resultSet.getMetaData().getColumnName(i).equals("record_count")){
                    continue;
                }
                System.out.printf(
                        "%20s",
                        resultSet.getMetaData().getColumnName(i));
            }
            System.out.println();
            while(resultSet.next())
            {
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    if (resultSet.getMetaData().getColumnName(i).equals("record_count")){
                        continue;
                    }
                    System.out.printf(
                            "%20s",
                            resultSet.getString(i)
                    );
                }
                System.out.println();
            }

        } catch (Exception e)
        {
            //System.out.println(e.getMessage());
            e.printStackTrace();
        }
        //В любом случае нужно освободить ресурсы       
        finally
        { 
            try
            {
                resultSet.close();
                statement.close();
                connection.close();
            }
            catch(Exception e)
            {
                
            }
        }
    }
}
    

