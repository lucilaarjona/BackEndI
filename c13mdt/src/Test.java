import java.sql.*;
public class Test {
    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGO; CREATE TABLE ODONTOLOGO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " APELLIDO varchar(100) NOT NULL,"
            + " MATRICULA varchar(100) NOT NULL"
            + " )";
    private static final String SQL_INSERT =  "INSERT INTO ODONTOLOGO (ID, NOMBRE, APELLIDO, MATRICULA) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE =  "UPDATE ODONTOLOGO SET MATRICULA=? WHERE ID=?";
    public static void main(String[] args) throws Exception{
        Odontologo odontologo = new Odontologo("Arjona", "Ricardo", "123456");
        Connection connection = null;
        try {
            connection= getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            psInsert.setInt(1, 1);
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.setString(4, odontologo.getMatricula());
            psInsert.execute();

            PreparedStatement psUpdate1 = connection.prepareStatement(SQL_UPDATE);
            psUpdate1.setString(1, odontologo.setMatricula("456789"));
            psUpdate1.setLong(2, 1);
            psUpdate1.execute();

            connection.setAutoCommit(false);
            PreparedStatement psUpdate2 = connection.prepareStatement(SQL_UPDATE);
            psUpdate2.setString(1, odontologo.setMatricula("987456"));
            psUpdate2.setInt(2, 1);
            psUpdate2.execute();
           // int a = 4 /0;
            connection.commit();
            connection.setAutoCommit(true);

            String sql = "SELECT * FROM ODONTOLOGO";
            Statement sqlSmt = connection.createStatement();
            ResultSet rs = sqlSmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
            }

        }catch (Exception e){
            connection.rollback();
        }finally {
            connection.close();
        }
        Connection connection2= getConnection();
        String sql = "SELECT * FROM ODONTOLOGO";
        Statement sqlSmt = connection2.createStatement();
        ResultSet rs = sqlSmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println(rs.getInt(1) + rs.getString(2) + rs.getString(3) + rs.getString(4));
        }
    }
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test");

    }
}
