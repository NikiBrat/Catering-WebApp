package IO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.naming.NamingException;

public class DbBroker {

    javax.naming.InitialContext ctx;
    javax.sql.DataSource ds;
    java.sql.Connection conn;
    private static String url = "jdbc:mysql://localhost:3306/ketering?autoReconnect=true&useSSL=false";
    //private static String url = "jdbc:mysql://localhost:3306/ketering?useUnicode=true&characterEncoding=UTF-8";

    private static Connection con;
    private static boolean uspesno;
    private static Statement st;
    private static String putanja = "";
    private static final String USER = "NikiBrat";
    private static final String PASS = "Momcina.123";
    //private static final String USER = "dejan";
    //private static final String PASS = "edi";

    public static void settings() {
        podesiPutanje();
        //kreirajBaze();
    }

    private static void podesiPutanje() {
        // "jdbc:sqlite:./baze/lager.db";
        //if (sett.sistem.contains("linux")) putanja ="./";
        //private static String url = "jdbc:mysql:local://./db.conf";
        //url  = "jdbc:sqlite:" + putanja + "baze/lager.db";       //  Tabela: lager
        //url = "jdbc:mysql://localhost:3306/ketering?autoReconnect=true&useSSL=false";
        //url = "jdbc:mysql://localhost:3306/ketering?useUnicode=true&characterEncoding=UTF-8";
    }

    public static boolean connect() {
        //url = "jdbc:mySubprotocol:myDataSource";
        //url = "jdbc:mckoi:local://./db.conf";
        //url  = "jdbc:sqlite:" + putanja + "baze/" + tabela + ".db";
        con = null;
        uspesno = false;
        try {
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.toString());
        }
        try {
            //con = DriverManager.getConnection(url, "myLogin", "myPassword");
            //con = DriverManager.getConnection("jdbc:sqlite:./baze/sample.db");
            con = DriverManager.getConnection(url, USER, PASS);
            con.setAutoCommit(true);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        try {
            st = con.createStatement();
            st.setQueryTimeout(20);  // set timeout to 20 sec.
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static boolean disConnect() {
        try {
            con.close();
            uspesno = true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            uspesno = false;
        }
        return uspesno;
    }

    public static ArrayList<String[]> getArr(String query) {
        connect();
        try {
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsMdata = rs.getMetaData();
            int colNo = rsMdata.getColumnCount();
            ArrayList<String[]> resultList = new ArrayList<>();
            //System.out.println("Upit iz klase DbBroker: " + query);
            while (rs.next()) {
                String[] rw = new String[colNo];
                for (int i = 1; i <= colNo; i++) {
                    rw[i - 1] = rs.getString(i);
                    // System.out.println("Odgovor na upit: " +rw[i-1]);
                }
                resultList.add(rw);
            }
            //System.out.println("<DbBroker> Podaci pročitani");
            disConnect();
            return resultList;
        } catch (SQLException ex) {
            ArrayList<String[]> r = new ArrayList<>();
            String[] s = new String[1];
            s[0] = ex.getMessage();
            System.out.println("<DbBroker> Greska kod getArr: " + s[0] + ", Upit: " + query);
            //showMessageDialog(null, "Greška kod pristupa bazi:\n" + ex.getMessage() );
            r.add(s);
            disConnect();
            return r;
        }
    }

    public static String getString(String query) {
        String str;
        connect();
        try {
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsMdata = rs.getMetaData();
            int colNo = rsMdata.getColumnCount();
            //System.out.println("Klasa DbBroker, metod getString(): Broj kolona: " + colNo);
            rs.next();
            str = rs.getString(1);
            disConnect();
            return str;
        } catch (SQLException ex) {
            ArrayList<String[]> r = new ArrayList<>();
            String s;
            s = ex.getMessage();
            System.out.println("<DbBroker> Greska kod getArr: " + s + ", Upit: " + query);
            disConnect();
            return "";
        }
    }

    public static ResultSet getResultSet(String query) {
        ResultSet rs = null;
        //connect();
        try {
            Statement st1 = con.createStatement();
            rs = st1.executeQuery(query);
            //disConnect();
        } catch (SQLException ex) {
            System.out.println("<DbBroker> Greska kod getResultSet() " + ex + ". Upit: " + query);
            //disConnect();
        }
        return rs;
    }

    public static boolean memorisiArr(String[][] elementi, int duzina, String tab) {
        boolean uspeh = true;
        //System.out.println("Metod memorisiArtikal, clanova niza: " + duzina);
        String komanda = "INSERT INTO " + tab + " (";
        for (int i = 1; i < duzina + 1; i++) {
            //System.out.println("" + i + ": " + elementi[1][i] + " = " + elementi[2][i]);
            komanda += elementi[1][i];
            if (i < duzina) {
                komanda += ", ";
            }
        }
        komanda += ") VALUES ( ";
        for (int i = 1; i < duzina + 1; i++) {
            komanda += "'" + elementi[2][i] + "'";
            if (i < duzina) {
                komanda += ", ";
            }
        }
        komanda += ")";
        System.out.println("DbBroker<memorisiArtikal> Komanda je: " + komanda);
        try {
            connect();
            st.executeUpdate(komanda);
        } catch (SQLException ex) {
            System.err.println("DbBroker<memorisiArtikal> Greška kod upisa artikla u bazu: " + ex.getMessage());
            uspeh = false;
        }
        //System.out.println("DbBroker<memorisiArtikal>: Sifra grupe je " + elementi[2][19]);
        System.out.println("DbBroker<memorisiArtikal>");
        disConnect();
        return uspeh;
    }

    public static boolean memorisiMap(Map<String, String> elementi, String tab) {
        String komanda, vrednost, key, k2;
        int i = 0, s = elementi.size();
        boolean uspeh = true;
        //System.out.println("Metod memorisiMap, clanova niza: " + duzina);
        komanda = "INSERT INTO " + tab + " (";
        k2 = ") VALUES (";
        for (Map.Entry<String, String> unos : elementi.entrySet()) {
            vrednost = unos.getValue().replace("'", "\"");
            key = unos.getKey();
            komanda += key;
            k2 += "'" + vrednost + "'";
            if (i < s - 1) {
                komanda += ", ";
                k2 += ", ";
            }
            i++;
            //System.out.println("Key = " + key + ", Value = " + vrednost);
        }
        komanda += k2 + ")";
        System.out.println("DbBroker<memorisiMap> Komanda je: " + komanda);
        try {
            connect();
            st.executeUpdate(komanda);
        } catch (SQLException ex) {
            System.err.println("DbBroker<memorisiMap> Greška kod upisa u bazu: " + ex.getMessage());
            uspeh = false;
        }
        System.out.println("DbBroker<memorisiMap> END");
        disConnect();
        return uspeh;
    }

    public static boolean updateMap(Map<String, String> elementi, String tab, String id) {
        String komanda, vrednost, key, k2;
        int i = 0, s = elementi.size();
        boolean uspeh = true;
        //System.out.println("Metod updateMap, clanova niza: " + duzina);
        komanda = "UPDATE " + tab + " SET ";

        //status='fgsgd', rep_call='" +znakOK + "' WHERE id='" + refid + "'  " ;
        k2 = " WHERE id=" + id;
        for (Map.Entry<String, String> unos : elementi.entrySet()) {
            vrednost = unos.getValue().replace("'", "\"");
            key = unos.getKey();
            komanda += " " + key + "= '" + vrednost + "'";
            if (i < s - 1) {
                komanda += ", ";
            }
            i++;
            //System.out.println("Key = " + key + ", Value = " + vrednost);
        }
        komanda += k2;
        System.out.println("DbBroker<updateMap> Komanda je: " + komanda);
        try {
            connect();
            st.executeUpdate(komanda);
        } catch (SQLException ex) {
            System.err.println("DbBroker<updateMap> Greška kod upisa u bazu: " + ex.getMessage());
            uspeh = false;
        }
        System.out.println("DbBroker<updateMap> END");
        disConnect();
        return uspeh;
    }

    public static boolean simpleQuery(String string) {
        boolean sveok;
        connect();
        try {
            st.executeUpdate(string);
            disConnect();
            sveok = true;
            //System.out.println("Upit kod simpleq: " + string);
        } catch (SQLException ex) {
            System.err.println("Greska kod simpleQuery: " + ex);
            System.err.println("Komanda: " + string);
            disConnect();
            sveok = false;
        }
        //System.out.println("Izvrsen simpleQuery");
        //System.out.println(string);
        disConnect();
        return sveok;
    }

    public static int scalar(String query) {
        if (!connect()) {
            System.err.println("Veza sa bazom nije uspostavljena!!!");
        }
        try {
            int res = -1;
            //Statement st=conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                res = rs.getInt(1);
            }
            disConnect();
            // System.out.println("Izvrsen scalar, upit: " + query);
            return res;
        } catch (SQLException ex) {
            System.out.println("Izvrsen scalar, greska: " + ex);
            System.out.println("Upit glasi: " + query);
            disConnect();
            return -1;
        }
    }

    public DbBroker() throws SQLException, NamingException {
        this.conn = ds.getConnection();
        this.ds = (javax.sql.DataSource) ctx.lookup("jdbc/SQLServer");
        this.ctx = new javax.naming.InitialContext();
    }

}
