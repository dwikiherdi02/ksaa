package resources.views.page.pembayaran.table;

public class ModelTable {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the noPengajuan
     */
    public String getNoPengajuan() {
        return noPengajuan;
    }

    /**
     * @param noPengajuan the noPengajuan to set
     */
    public void setNoPengajuan(String noPengajuan) {
        this.noPengajuan = noPengajuan;
    }

    /**
     * @return the namaNasabah
     */
    public String getNamaNasabah() {
        return namaNasabah;
    }

    /**
     * @param namaNasabah the namaNasabah to set
     */
    public void setNamaNasabah(String namaNasabah) {
        this.namaNasabah = namaNasabah;
    }

    /**
     * @return the nominalCicilan
     */
    public String getNominalCicilan() {
        return nominalCicilan;
    }

    /**
     * @param nominalCicilan the nominalCicilan to set
     */
    public void setNominalCicilan(String nominalCicilan) {
        this.nominalCicilan = nominalCicilan;
    }

    /**
     * @return the tanggalBayar
     */
    public String getTanggalBayar() {
        return tanggalBayar;
    }

    /**
     * @param tanggalBayar the tanggalBayar to set
     */
    public void setTanggalBayar(String tanggalBayar) {
        this.tanggalBayar = tanggalBayar;
    }

    /**
     * @return the caraBayar
     */
    public String getCaraBayar() {
        return caraBayar;
    }

    /**
     * @param caraBayar the caraBayar to set
     */
    public void setCaraBayar(String caraBayar) {
        this.caraBayar = caraBayar;
    }

    public ModelTable(int id, String noPengajuan, String namaNasabah, String nominalCicilan, String tanggalBayar, String caraBayar) {
        this.id = id;
        this.noPengajuan = noPengajuan;
        this.namaNasabah = namaNasabah;
        this.nominalCicilan = nominalCicilan;
        this.tanggalBayar = tanggalBayar;
        this.caraBayar = caraBayar;
    }

    public ModelTable() {
    }
   
    private int id;
    private String noPengajuan;
    private String namaNasabah;
    private String nominalCicilan;
    private String tanggalBayar;
    private String caraBayar;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {noPengajuan, namaNasabah, nominalCicilan, tanggalBayar, caraBayar, new ModelAction(this, event)};
    }
}
