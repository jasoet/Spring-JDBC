package id.ac.pcr.springjdbc.service;

import id.ac.pcr.springjdbc.model.Dosen;
import id.ac.pcr.springjdbc.model.MataKuliah;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Deny Prasetyo
 * Date: 4/2/13
 * Time: 11:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class PendaftaranService {


    @Transactional
    public boolean daftar(Dosen dosen, MataKuliah mataKuliah) {
        return false;
    }
}
