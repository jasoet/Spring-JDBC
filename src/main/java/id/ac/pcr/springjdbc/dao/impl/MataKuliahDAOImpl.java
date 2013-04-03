/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pcr.springjdbc.dao.impl;

import id.ac.pcr.springjdbc.dao.MataKuliahDAO;
import id.ac.pcr.springjdbc.model.Dosen;
import id.ac.pcr.springjdbc.model.MataKuliah;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jasoet
 */
@Component
public class MataKuliahDAOImpl implements MataKuliahDAO {


    @Autowired
    private DataSource dataSource;


    public List<MataKuliah> getAll() throws SQLException {
        String sql = "SELECT mk.mata_kuliah_id as id,mk.kode,mk.nama, "
                + " d.dosen_id,d.niy as dosen_niy,d.nama as dosen_nama "
                + " FROM mata_kuliah mk  "
                + " INNER JOIN dosen d ON (mk.dosen_id = d.dosen_id)";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<MataKuliah> data = new ArrayList<MataKuliah>();
        while (rs.next()) {
            Dosen d = new Dosen();
            d.setId(rs.getInt("dosen_id"));
            d.setNama(rs.getString("dosen_nama"));
            d.setNiy(rs.getString("dosen_niy"));

            MataKuliah mk = new MataKuliah();
            mk.setId(rs.getInt("Id"));
            mk.setNama(rs.getString("nama"));
            mk.setKode(rs.getString("kode"));
            mk.setDosen(d);

            data.add(mk);
        }
        return data;
    }

    public List<MataKuliah> getByNama(String nama) throws SQLException {
        String sql = "SELECT mk.mata_kuliah_id as id,mk.kode,mk.nama, "
                + " d.dosen_id,d.niy as dosen_niy,d.nama as dosen_nama "
                + " FROM mata_kuliah mk  "
                + " INNER JOIN dosen d ON (mk.dosen_id = d.dosen_id)"
                + " WHERE mk.nama LIKE ? ";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, "%" + nama + "%");
        ResultSet rs = ps.executeQuery();

        List<MataKuliah> data = new ArrayList<MataKuliah>();
        while (rs.next()) {
            Dosen d = new Dosen();
            d.setId(rs.getInt("dosen_id"));
            d.setNama(rs.getString("dosen_nama"));
            d.setNiy(rs.getString("dosen_niy"));

            MataKuliah mk = new MataKuliah();
            mk.setId(rs.getInt("Id"));
            mk.setNama(rs.getString("nama"));
            mk.setKode(rs.getString("kode"));
            mk.setDosen(d);

            data.add(mk);
        }
        return data;
    }

    @Transactional
    public int insert(MataKuliah d) throws SQLException {
        String sql = "INSERT INTO mata_kuliah (kode,nama,dosen_id) VALUES (?,?,?)";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, d.getKode());
        ps.setString(2, d.getNama());
        ps.setInt(3, d.getDosen().getId());
        return ps.executeUpdate();
    }

    @Transactional
    public int delete(int id) throws SQLException {
        String sql = "DELETE FROM mata_kuliah WHERE mata_kuliah_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    @Transactional
    public int update(int id, MataKuliah newMataKuliah) throws SQLException {
        String sql = "UPDATE mata_kuliah SET kode=?,nama=?,dosen_id=? WHERE mata_kuliah_id=?";
        PreparedStatement ps = dataSource.getConnection().prepareStatement(sql);
        ps.setString(1, newMataKuliah.getKode());
        ps.setString(2, newMataKuliah.getNama());
        ps.setString(3, newMataKuliah.getDosen().getNiy());
        ps.setInt(4, id);
        return ps.executeUpdate();
    }
}
