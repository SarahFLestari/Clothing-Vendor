package Database;

import Model.AdminPreOrder;
import Model.Jasa;
import Model.Bahan;
import Model.Pemesanan;
import Model.PreOrder;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class Database {
    private Connection connection;
    private Statement statement = null;
    
    public void setConnection(){
        try{
            String username = "root";
            String password = "";
            String url = "jdbc:mysql://localhost:3306/impal";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            System.out.println("Connected");
        }
        catch(SQLException e){
            System.out.println(e);
            System.out.println("Not Connected");
        }
    }
    
    public static Connection ConnectDB (){
        try{
            Class.forName("com.mysql.jdbc.Driver"); 
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/impal","root","");
            JOptionPane.showMessageDialog(null,"Berhasil tersambung ke database");
            return connection;
        }
        catch (HeadlessException | ClassNotFoundException | SQLException e){
            JOptionPane.showMessageDialog(null, "Gagal tersambung ke database");
            return null;
        }
    } 
    
    public Connection getConnection(){
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/impal","root","");
            return con;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Gagal tersambung ke database");
            return null;
        }
    }
    
        public void savePreOrder(PreOrder p) {
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO preorder (email , nama, namaBahan, namaJasa, jumlahBaju, totalHarga) VALUES "
                    + "('" +p.getEmail()
                    +"','" +p.getNama()
                    +"','" +p.getNamaBahan()
                    +"','" +p.getNamaJasa()
                    +"','" +p.getJumlahBaju()
                    +"','" +p.getTotalHarga()
                    +"')";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "PreOrder Berhasil");
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "PreOrder Gagal");
        }
    }
    public void savePemesanan(Pemesanan p) {
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO dataPemesanan (email , nama, namaBahan, namaJasa, jumlahBaju, totalHarga, Status) VALUES "
                    + "('" +p.getEmail()
                    +"','" +p.getNama()
                    +"','" +p.getNamaBahan()
                    +"','" +p.getNamaJasa()
                    +"','" +p.getJumlahBaju()
                    +"','" +p.getTotalHarga()
                    +"','" +p.getStatus()
                    +"')";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Pemesanan Berhasil");
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Pemesanan Gagal");
        }
    }
    public ArrayList<PreOrder> getPreOrderList(){
        ArrayList<PreOrder> ListPreOrder = new ArrayList<PreOrder>();
        Connection connection = getConnection();
        String query = "SELECT * FROM PreOrder";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            PreOrder po;
            while (rs.next()){
                po = new PreOrder(rs.getString("email"), rs.getString("nama"), rs.getString("namaBahan"), rs.getString("namaJasa"), rs.getString("jumlahBaju"), rs.getString("totalHarga"));
                ListPreOrder.add(po);
            }
        } catch (Exception e){
            
            e.printStackTrace();
        }
        return ListPreOrder;
    }
        public ArrayList<AdminPreOrder> getAdminPreOrder(){
        ArrayList<AdminPreOrder> ListAdminPreOrder = new ArrayList<AdminPreOrder>();
        Connection connection = getConnection();
        String query = "SELECT * FROM preorder";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            AdminPreOrder p;
            while (rs.next()){
                p = new AdminPreOrder(rs.getString("id_preorder"),rs.getString("email"), rs.getString("nama"), rs.getString("namaBahan"), rs.getString("namaJasa"), rs.getString("jumlahBaju"), rs.getString("totalHarga"));
                ListAdminPreOrder.add(p);
            }
        } catch (Exception e){
            
            e.printStackTrace();
        }
        return ListAdminPreOrder;
    }
    public ArrayList<Pemesanan> getPemesanan(){
        ArrayList<Pemesanan> ListPemesanan = new ArrayList<Pemesanan>();
        Connection connection = getConnection();
        String query = "SELECT * FROM dataPemesanan";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Pemesanan p;
            while (rs.next()){
                p = new Pemesanan(rs.getString("email"), rs.getString("nama"), rs.getString("namaBahan"), rs.getString("namaJasa"), rs.getString("jumlahBaju"), rs.getString("totalHarga"), rs.getString("Status"));
                ListPemesanan.add(p);
            }
        } catch (Exception e){
            
            e.printStackTrace();
        }
        return ListPemesanan;
    }
   
    public void saveBahan(Bahan b){
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO daftarBahan VALUES "
                    + "('"+b.getIdBahan()
                    +"','" +b.getNamaBahan() 
                    +"','" +b.getHarga()
                    +"')";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Bahan berhasil disimpan ke database");
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Bahan gagal disimpan ke database");
        }
    }
    public void updateBahan(Bahan bhn) {
        try {
            Statement stmt = connection.createStatement();
            String query = "UPDATE daftarBahan SET idBahan='"+bhn.getIdBahan()+"',namaBahan='"+bhn.getNamaBahan()+"',harga='"+bhn.getHarga()+"' WHERE idBahan= '"+bhn.getIdBahan()+"'";
            stmt.execute(query);
//            executeSQLQuery(query,"Bahan berhasil diupdate");
            JOptionPane.showMessageDialog(null, "Bahan berhasil diupdate");
        } catch (Exception ae){
            JOptionPane.showMessageDialog(null, "Maaf, bahan yang ada ingin update gagal ");
        }
    }   
    public void hapusBahan(Bahan bhn) {
        try{        
                Statement stmt = connection.createStatement();
                    String query = "DELETE FROM daftarBahan WHERE idBahan='"+bhn.getIdBahan()+"'";
                    stmt.execute(query);
                    JOptionPane.showMessageDialog(null, "Bahan berhasil dihapus");
//                    executeSQLQuery(query,"Bahan berhasil dihapus");
                } catch (Exception ae){
                    JOptionPane.showMessageDialog(null, "Maaf, bahan yang ada ingin hapus gagal ");
                }
    }
    public ArrayList<Bahan> loadBahan() {
        try {
            ArrayList<Bahan> daftarBahan = new ArrayList<>();
            String query = "select * from daftarBahan";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
               Bahan b= new Bahan(rs.getString(1), rs.getString(2), rs.getInt(3));
               daftarBahan.add(b);
            }
            return daftarBahan;
        } catch (HeadlessException | SQLException e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load bahan");
        }
    }    
        
    public ArrayList<Bahan> getListBahan(){
        ArrayList<Bahan> ListBahan = new ArrayList<Bahan>();
        Connection connection = getConnection();
        String query = "SELECT * FROM daftarBahan";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Bahan listbahan;
            while (rs.next()){
                listbahan = new Bahan(rs.getString("idBahan"), rs.getString("namaBahan"), rs.getInt("harga"));
                ListBahan.add(listbahan);
            }
        } catch (SQLException e){          
            throw new IllegalArgumentException("Maaf, gagal mendapatkan list bahan");
        }
        return ListBahan;
    }
  
    public void saveJasa(Jasa j) {
        try {
            Statement stmt = connection.createStatement();
            String query = "INSERT INTO daftarJasa VALUES "
                    + "('"+j.getIdJasa()
                    +"','" +j.getNamaJasa() 
                    +"','" +j.getTarif()
                    +"')";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Jasa berhasil disimpan ke database");
        }
        catch(SQLException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Jasa gagal disimpan ke database");
        }
    }
    
    public ArrayList<Jasa> loadJasa() {
        try {
            ArrayList<Jasa> daftarJasa = new ArrayList<>();
            String query = "select * from daftarJasa";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
               Jasa j= new Jasa(rs.getString(1), rs.getString(2), rs.getInt(3));
               daftarJasa.add(j);
            }
            return daftarJasa;
        } catch (HeadlessException | SQLException e) {
            throw new IllegalArgumentException("Terjadi kesalahan saat load Jasa");
        }
    }    
    
    public ArrayList<Jasa> getListJasa(){
        ArrayList<Jasa> JasaList = new ArrayList<Jasa>();
        Connection connection = getConnection();
        String query = "SELECT * FROM daftarJasa";
        Statement st;
        ResultSet rs;
        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Jasa listjasa;
            while (rs.next()){
                listjasa = new Jasa(rs.getString("idJasa"), rs.getString("namaJasa"), rs.getInt("tarif"));
                JasaList.add(listjasa);
            }
        } catch (HeadlessException | SQLException e){          
            throw new IllegalArgumentException("Maaf, gagal mendapatkan list jasa");
        }
        return JasaList;
    }
    
    public void updateJasa(Jasa js) {
        try {
            Statement stmt = connection.createStatement();
            String query = "UPDATE daftarJasa SET idJasa='"+js.getIdJasa()+"',namaJasa='"+js.getNamaJasa()+"',tarif='"+js.getTarif()+"' WHERE idJasa= '"+js.getIdJasa()+"'";
//            executeSQLQuery(query,"Jasa berhasil diupdate");
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Jasa berhasil diupdate");
            } catch (Exception ae){
            JOptionPane.showMessageDialog(null, "Maaf, jasa yang ada ingin update gagal ");
            }
    }
    public void hapusJasa(Jasa js) {
        try{
                Statement stmt = connection.createStatement();
                String query = "DELETE FROM daftarJasa WHERE idJasa='"+js.getIdJasa()+"'";
                stmt.execute(query);
                JOptionPane.showMessageDialog(null, "Jasa berhasil dihapus");
//                executeSQLQuery(query,"Jasa berhasil dihapus");
                } catch (Exception ae){
                    JOptionPane.showMessageDialog(null, "Maaf, jasa yang ada ingin hapus gagal ");
                }
    }
    public ResultSet getHargaBahan(String namaBahan) throws SQLException {
        String query = "Select harga from daftarBahan where namaBahan = '"+namaBahan+"'";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    public ResultSet getTarifJasa(String namaJasa) throws SQLException {
        String query = "Select tarif from daftarJasa where namaJasa = '"+namaJasa+"'";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
    
    public void deletePreOrder(AdminPreOrder p){
        try{
            Statement stmt = connection.createStatement();
            String query = "DELETE FROM preorder WHERE id_preorder = '"+p.getId_preorder()+"'";
            stmt.execute(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus, Pilih Menu Update Data Pemesanan PreOrder di Menu Admin Untuk Melihat Tabel Data PreOrder ");
            //executeSQLQuery(query,"Data berhasil dihapus");
            } catch (Exception ae){
                JOptionPane.showMessageDialog(null, "Maaf, data yang ada ingin hapus gagal ");
            }  
     }
}


    
    





    
    
   
