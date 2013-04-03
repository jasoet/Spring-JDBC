package id.ac.pcr.springjdbc.dao.impl;

import id.ac.pcr.springjdbc.dao.MahasiswaDAO;
import id.ac.pcr.springjdbc.model.Dosen;
import id.ac.pcr.springjdbc.model.Mahasiswa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: isaninside
 * Date: 4/3/13
 * Time: 10:02 AM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class MahasiswaDAOImpl implements MahasiswaDAO {

    @Autowired
    private DataSource dataSource;

    @Override
    public Mahasiswa getByNim(String nim) throws SQLException {
        String sql = "SELECT d.mahasiswa_id as id,d.nim,d.nama FROM mahasiswa d WHERE d.nim=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);

        ps.setString(1, nim);
        ResultSet rs = ps.executeQuery();

        Mahasiswa result = null;

        if (rs.next()) {
            result = new Mahasiswa();
            result.setId(rs.getInt("id"));
            result.setNim(rs.getString("nim"));
            result.setNama(rs.getString("nama"));
        }
        return result;
    }

    @Override
    public List<Mahasiswa> getAll() throws SQLException {
        String sql = "SELECT d.mahasiswa_id AS id,d.nim,d.nama FROM mahasiswa d";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Mahasiswa> data = new ArrayList<Mahasiswa>();

        while (rs.next()) {
            Mahasiswa d = new Mahasiswa();
            d.setId(rs.getInt("id"));
            d.setNim(rs.getString("nim"));
            d.setNama(rs.getString("nama"));
            data.add(d);
        }

        return data;
    }

    @Override
    public List<Mahasiswa> getByNama(String nama) throws SQLException {
        String sql = "SELECT d.mahasiswa_id AS id,d.nim,d.nama FROM mahasiswa d WHERE d.nama LIKE ?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");

        ResultSet rs = ps.executeQuery();
        List<Mahasiswa> data = new ArrayList<Mahasiswa>();

        while (rs.next()) {
            Mahasiswa d = new Mahasiswa();
            d.setId(rs.getInt("id"));
            d.setNim(rs.getString("nim"));
            d.setNama(rs.getString("nama"));
            data.add(d);
        }

        return data;
    }

    @Override
    public int insert(Mahasiswa d) throws SQLException {
        String sql = "INSERT INTO mahasiswa (nim,nama) VALUES (?,?)";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, d.getNim());
        ps.setString(2, d.getNama());
        return ps.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM mahasiswa WHERE mahasiswa_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Override
    public int update(int id, Mahasiswa newMahasiswa) throws SQLException {
        String sql = "UPDATE mahasiswa SET nim=?,nama=? WHERE mahasiswa_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, newMahasiswa.getNim());
        ps.setString(2, newMahasiswa.getNama());
        ps.setInt(3, id);
        return ps.executeUpdate();
    }
}
