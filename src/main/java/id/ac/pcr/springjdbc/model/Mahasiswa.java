package id.ac.pcr.springjdbc.model;

/**
 * Created with IntelliJ IDEA.
 * User: isaninside
 * Date: 4/3/13
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class Mahasiswa {
    private int id;
    private String nama;
    private String nim;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
}
