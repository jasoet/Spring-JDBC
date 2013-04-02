package id.ac.pcr.springjdbc.main;

import id.ac.pcr.springjdbc.dao.DosenDAO;
import id.ac.pcr.springjdbc.model.Dosen;
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

        DosenDAO dosenDAO = acp.getBean("dosenDAOimpl", DosenDAO.class);

        try {
            List<Dosen> dosenList = dosenDAO.getAll();
            System.out.println(dosenList.size());
        } catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }
    }
}
