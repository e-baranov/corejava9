package epk.sam.ebooks.corejava9.v2.ch04;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.sql.*;

/**
 * Executes all SQL statements in a file. Call this program as <br>
 * java -classpath driverPath:. ExecSQL commandFile
 * 
 * @version 1.31 2012-06-05
 * @author Cay Horstmann
 */
class ExecSQL
{
   @SuppressWarnings("resource")
public static void main(String args[]) throws IOException
   {
      try
      {
         Scanner in = args.length == 0 ? new Scanner(System.in) : new Scanner(Paths.get(args[0]));

         try (Connection conn = getConnection())
         {
            Statement stat = conn.createStatement();

            while (true)
            {
               if (args.length == 0) System.out.println("Enter command or EXIT to exit:");

               if (!in.hasNextLine()) return;

               String line = in.nextLine();
               if (line.equalsIgnoreCase("EXIT")) return;
               if (line.trim().endsWith(";")) // remove trailing semicolon
               {
                  line = line.trim();
                  line = line.substring(0, line.length() - 1);
               }
               try
               {
                  boolean isResult = stat.execute(line);
                  if (isResult)
                  {
                     ResultSet rs = stat.getResultSet();
                     showResultSet(rs);
                  }
                  else
                  {
                     int updateCount = stat.getUpdateCount();
                     System.out.println(updateCount + " rows updated");
                  }
               }
               catch (SQLException ex)
               {
                  for (Throwable e : ex)
                     e.printStackTrace();
               }
            }
         }
      }
      catch (SQLException e)
      {
         for (Throwable t : e)
            t.printStackTrace();
      }
   }

   /**
    * Gets a connection from the properties specified in the file database.properties
    * @return the database connection
    */
   public static Connection getConnection() throws SQLException, IOException
   {
	   // you might be interested to know that the default username / password pair for Derby is derbyuser / derbyuser.
	  //база должна лежать там, откуда запущен startNetworkServer.bat,т.к. url не задаёт путь, а только имя базы
	   // Подсунул туда каталог COREJAVA из примеров этой главы, чтобы набитые данные там уже были
	   // Оригинал этой базы лежит в COREJAVA.7z в resources
	   // %derby_home%/bin/COREJAVA. Помещать все двоичные файлы базы в git плохо
      Properties props = new Properties();
      ClassLoader loader = Thread.currentThread().getContextClassLoader();
      
      // Переменная среды %DERBY_HOME% указывает на интсалляцию derby
      // в eclipse так не находит
//      try (InputStream in = Files.newInputStream(Paths.get("database.properties")))
      try (InputStream in = loader.getResourceAsStream("database.properties"))
      
//      try (InputStream in = Files.newInputStream(Paths.get("/src/main/java/epk/sam/ebooks/corejava9/v2/ch04/database.properties")))
      {
         props.load(in);
      }

      String drivers = props.getProperty("jdbc.drivers");
      if (drivers != null) System.setProperty("jdbc.drivers", drivers);

      String url = props.getProperty("jdbc.url");
      String username = props.getProperty("jdbc.username");
      String password = props.getProperty("jdbc.password");

      return DriverManager.getConnection(url, username, password);
   }

   /**
    * Prints a result set.
    * @param result the result set to be printed
    */
   public static void showResultSet(ResultSet result) throws SQLException
   {
      ResultSetMetaData metaData = result.getMetaData();
      int columnCount = metaData.getColumnCount();

      for (int i = 1; i <= columnCount; i++)
      {
         if (i > 1) System.out.print(", ");
         System.out.print(metaData.getColumnLabel(i));
      }
      System.out.println();

      while (result.next())
      {
         for (int i = 1; i <= columnCount; i++)
         {
            if (i > 1) System.out.print(", ");
            System.out.print(result.getString(i));
         }
         System.out.println();
      }
   }
}
