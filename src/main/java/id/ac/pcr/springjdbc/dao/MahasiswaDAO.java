/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pcr.springjdbc.dao;

import id.ac.pcr.springjdbc.model.Dosen;
import id.ac.pcr.springjdbc.model.Mahasiswa;

import java.sql.SQLException;
import java.util.List;

/**
 * @author jasoet
 */
public interface MahasiswaDAO {

    public Mahasiswa getByNim(String nim) throws SQLException;

    public List<Mahasiswa> getAll() throws SQLException;

    public List<Mahasiswa> getByNama(String nama) throws SQLException;

    public int insert(Mahasiswa d) throws SQLException;

    public int delete(int id) throws SQLException;

    public int update(int id, Mahasiswa newMahasiswa) throws SQLException;
}
