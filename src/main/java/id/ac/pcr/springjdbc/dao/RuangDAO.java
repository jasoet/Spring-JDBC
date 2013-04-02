/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.pcr.springjdbc.dao;

import java.sql.SQLException;
import java.util.List;
import id.ac.pcr.springjdbc.model.Ruang;

/**
 *
 * @author jasoet
 */
public interface RuangDAO {

    public List<Ruang> getAll() throws SQLException;

    public List<Ruang> getByNama(String nama) throws SQLException;

    public int insert(Ruang d) throws SQLException;

    public int delete(int id) throws SQLException;

    public int update(int id, Ruang newRuang) throws SQLException;
}
