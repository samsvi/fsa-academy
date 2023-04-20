package sk.posam.fsa.jpa;

import sk.posam.fsa.jpa.domain.Actor;

import java.sql.*;

public class JdbcApplication {

    private static final String url = "jdbc:postgresql://localhost:5432/dvdrental";
    private static final String user = "postgres";
    private static final String password = "SamkO313";

    public static void main(String[] args) {

        Connection connection = null;

        try{
            connection = DriverManager.getConnection(url, user, password);
            //pocetHercov(connection);
            ///zoznamHercov(connection);
            //najdiHercaPodlaId(123, connection);

/*
            //Pre overenie
            Actor a = najdiHercaPodlaId(123, connection);
            System.out.println("Herec: " + a.getFirstName() + " " + a.getLastname());
*/

            vlozHerca("Jan", "Hrach", connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metoda vypise pocet hercov v DB
     */
    private static void pocetHercov(Connection connection) {
        System.out.println("----------------------------------");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM actor");
            resultSet.next();
            int count = resultSet.getInt(1);
            System.out.println("Pocet hercov v db je: " + count);

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------------------------");
    }

    /**
     * Metoda vypise meno a priezvisko kazdeho herca ulozeneho v DB
     */
    private static void zoznamHercov(Connection connection) {
        System.out.println("---------------------------------");
        System.out.println("Zoznam hercov");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT actor_id, first_name, last_name FROM actor");
            while (resultSet.next()) {
                long id = resultSet.getLong("actor_id");
                String krstneMeno = resultSet.getString("first_name");
                String priezvisko = resultSet.getString("last_name");
                System.out.println("Meno a priezvisko: " + krstneMeno + " " + "priezvisko");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------------------");
    }

    /**
     * Metoda najde v DB herca so zadanym ID a vrati ho ako navratovu hodnotu
     */
    private static Actor najdiHercaPodlaId(int actorId, Connection connection) {
        try {
            String sql = "SELECT actor_id,first_name,last_name FROM actor WHERE actor_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, actorId);
            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()) {
                Actor actor = new Actor(resultSet.getString("first_name"), resultSet.getString("last_name"));
                resultSet.close();
                statement.close();
                return actor;
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metoda vytvori v DB noveho herca a vrati true, ak sa ho podarilo vlozit
     */
    private static boolean vlozHerca(String meno, String priezvisko, Connection conn) {
        try {
            String SQL = "INSERT INTO actor(first_name,last_name) VALUES(?,?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, meno);
            pstmt.setString(2, priezvisko);
            int affectedRows = pstmt.executeUpdate();

            if(affectedRows == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

}
