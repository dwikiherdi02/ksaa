package resources.views.page.laporan.menunggak.table;

public class ModelTable {

    /**
     * @return the sisa
     */
    public String getSisa() {
        return sisa;
    }

    /**
     * @param sisa the sisa to set
     */
    public void setSisa(String sisa) {
        this.sisa = sisa;
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
     * @return the modal
     */
    public String getModal() {
        return modal;
    }

    /**
     * @param modal the modal to set
     */
    public void setModal(String modal) {
        this.modal = modal;
    }

    /**
     * @return the laba
     */
    public String getLaba() {
        return laba;
    }

    /**
     * @param laba the laba to set
     */
    public void setLaba(String laba) {
        this.laba = laba;
    }

    /**
     * @return the lfnDate
     */
    public String getLfnDate() {
        return lfnDate;
    }

    /**
     * @param lfnDate the lfnDate to set
     */
    public void setLfnDate(String lfnDate) {
        this.lfnDate = lfnDate;
    }

    /**
     * @return the estDate
     */
    public String getEstDate() {
        return estDate;
    }

    /**
     * @param estDate the estDate to set
     */
    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }

    public ModelTable(String noPengajuan, String namaNasabah, String sisa, String modal, String laba, String lfnDate, String estDate) {
        this.noPengajuan = noPengajuan;
        this.namaNasabah = namaNasabah;
        this.sisa = sisa;
        this.modal = modal;
        this.laba = laba;
        this.lfnDate = lfnDate;
        this.estDate = estDate;
    }

    public ModelTable() {
    }
   
    private String noPengajuan;
    private String namaNasabah;
    private String sisa;
    private String modal;
    private String laba;
    private String lfnDate;
    private String estDate;
    
    public Object[] toRowTable() {
        return new Object[] {noPengajuan, namaNasabah, sisa, modal, laba, lfnDate, estDate};
    }
}
