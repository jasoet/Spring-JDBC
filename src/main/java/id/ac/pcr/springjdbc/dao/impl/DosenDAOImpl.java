package id.ac.pcr.springjdbc.dao.impl;

import id.ac.pcr.springjdbc.dao.DosenDAO;
import id.ac.pcr.springjdbc.model.Dosen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component("dosenDAOimpl")
public class DosenDAOImpl implements DosenDAO {


    @Autowired
    private DataSource dataSource;


    @Override
    public Dosen getByNiy(String niy) throws SQLException {
        String sql = "SELECT d.dosen_id as id,d.niy,d.nama FROM dosen d WHERE d.niy=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);

        ps.setString(1, niy);
        ResultSet rs = ps.executeQuery();

        Dosen result = null;

        if (rs.next()) {
            result = new Dosen();
            result.setId(rs.getInt("id"));
            result.setNiy(rs.getString("niy"));
            result.setNama(rs.getString("nama"));

        }
        return result;

    }

    public List<Dosen> getAll() throws SQLException {
        String sql = "SELECT d.dosen_id AS id,d.niy,d.nama FROM dosen d";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Dosen> data = new ArrayList<Dosen>();

        while (rs.next()) {
            Dosen d = new Dosen();
            d.setId(rs.getInt("id"));
            d.setNiy(rs.getString("niy"));
            d.setNama(rs.getString("nama"));
            data.add(d);
        }

        return data;

    }

    public List<Dosen> getByNama(String nama) throws SQLException {
        String sql = "SELECT d.dosen_id AS id,d.niy,d.nama FROM dosen d WHERE d.nama LIKE ?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");

        ResultSet rs = ps.executeQuery();
        List<Dosen> data = new ArrayList<Dosen>();

        while (rs.next()) {
            Dosen d = new Dosen();
            d.setId(rs.getInt("id"));
            d.setNiy(rs.getString("niy"));
            d.setNama(rs.getString("nama"));
            data.add(d);
        }

        return data;
    }

    @Transactional
    public int insert(Dosen d) throws SQLException {
        String sql = "INSERT INTO dosen (niy,nama) VALUES (?,?)";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, d.getNiy());
        ps.setString(2, d.getNama());
        return ps.executeUpdate();
    }

    @Transactional
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM dosen WHERE dosen_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Transactional
    public int update(int id, Dosen newDosen) throws SQLException {
        String sql = "UPDATE dosen SET niy=?,nama=? WHERE dosen_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, newDosen.getNiy());
        ps.setString(2, newDosen.getNama());
        ps.setInt(3, id);
        return ps.executeUpdate();
    }
}
