package id.ac.pcr.springjdbc.main;

import id.ac.pcr.springjdbc.dao.DosenDAO;
import id.ac.pcr.springjdbc.dao.MahasiswaDAO;
import id.ac.pcr.springjdbc.dao.MataKuliahDAO;
import id.ac.pcr.springjdbc.model.Dosen;
import id.ac.pcr.springjdbc.model.Mahasiswa;
import id.ac.pcr.springjdbc.model.MataKuliah;
import id.ac.pcr.springjdbc.provider.ApplicationContextProvider;
import org.springframework.context.ApplicationContext;

import java.sql.SQLException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Deny Prasetyo
 * Date: 4/2/13
 * Time: 10:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext acp = ApplicationContextProvider.getInstance().getApplicationContext();

        DosenDAO dosenDAO = acp.getBean("dosenDAOImpl", DosenDAO.class);
        MahasiswaDAO mahasiswaDAO = acp.getBean("mahasiswaDAOImpl", MahasiswaDAO.class);
        MataKuliahDAO matakuliahDAO = acp.getBean("mataKuliahDAOImpl",MataKuliahDAO.class );

        try {
            /*Mahasiswa newMahasiswa = new Mahasiswa();
            newMahasiswa.setNim("12344645");
            newMahasiswa.setNama("Anton Kinawa");
            mahasiswaDAO.insert(newMahasiswa);*/

            /*Dosen baru = new Dosen();
            baru.setNama("Muhammad Ihsan Zul");
            baru.setNiy("138203");
            dosenDAO.insert(baru);*/

            Dosen d = dosenDAO.getByNiy("010");

            MataKuliah mk = new MataKuliah();
            /*mk.setKode("235");
            mk.setNama("Pemrograman Framework");
            mk.setDosen(d);

            matakuliahDAO.insert(mk);*/
            matakuliahDAO.delete(11);



            List<Mahasiswa> mahasiswaList = mahasiswaDAO.getAll();
            List<Dosen> dosenList = dosenDAO.getAll();
            List<MataKuliah> mataKuliahList = matakuliahDAO.getAll();
            System.out.println(dosenList.size());
            System.out.println(mahasiswaList.size());
            System.out.println(mahasiswaList.size());
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
