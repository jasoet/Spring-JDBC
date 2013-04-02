package id.ac.pcr.springjdbc.dao.impl;

import id.ac.pcr.springjdbc.dao.RuangDAO;
import id.ac.pcr.springjdbc.model.Ruang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RuangDAOImpl implements RuangDAO {

    @Autowired
    private DataSource dataSource;


    public List<Ruang> getAll() throws SQLException {
        String sql = "SELECT d.ruang_id AS id,d.nama,d.keterangan FROM ruang d";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Ruang> data = new ArrayList<Ruang>();

        while (rs.next()) {
            Ruang d = new Ruang();
            d.setId(rs.getInt("id"));
            d.setNama(rs.getString("nama"));
            d.setKeterangan(rs.getString("keterangan"));
            data.add(d);
        }

        return data;

    }

    public List<Ruang> getByNama(String nama) throws SQLException {
        String sql = "SELECT d.ruang_id AS id,d.nama,d.keterangan FROM ruang d WHERE d.nama LIKE ?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");

        ResultSet rs = ps.executeQuery();
        List<Ruang> data = new ArrayList<Ruang>();

        while (rs.next()) {
            Ruang d = new Ruang();
            d.setId(rs.getInt("id"));
            d.setNama(rs.getString("nama"));
            d.setKeterangan(rs.getString("keterangan"));
            data.add(d);
        }

        return data;
    }

    @Transactional
    public int insert(Ruang d) throws SQLException {
        String sql = "INSERT INTO ruang (nama,keterangan) VALUES (?,?)";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, d.getNama());
        ps.setString(2, d.getKeterangan());
        return ps.executeUpdate();
    }

    @Transactional
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM ruang WHERE ruang_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Transactional
    public int update(int id, Ruang newRuang) throws SQLException {
        String sql = "UPDATE ruang SET nama=?,keterangan=? WHERE ruang_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, newRuang.getNama());
        ps.setString(2, newRuang.getKeterangan());
        ps.setInt(3, id);
        return ps.executeUpdate();
    }
}
