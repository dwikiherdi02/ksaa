package resources.views.page.pengajuan.table;


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
     * @return the no
     */
    public String getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * @return the nasabah
     */
    public String getNasabah() {
        return nasabah;
    }

    /**
     * @param nasabah the nasabah to set
     */
    public void setNasabah(String nasabah) {
        this.nasabah = nasabah;
    }

    /**
     * @return the tppengajuan
     */
    public String getTppengajuan() {
        return tppengajuan;
    }

    /**
     * @param tppengajuan the tppengajuan to set
     */
    public void setTppengajuan(String tppengajuan) {
        this.tppengajuan = tppengajuan;
    }

    /**
     * @return the barang
     */
    public String getBarang() {
        return barang;
    }

    /**
     * @param barang the barang to set
     */
    public void setBarang(String barang) {
        this.barang = barang;
    }

    /**
     * @return the tpbarang
     */
    public String getTpbarang() {
        return tpbarang;
    }

    /**
     * @param tpbarang the tpbarang to set
     */
    public void setTpbarang(String tpbarang) {
        this.tpbarang = tpbarang;
    }

    /**
     * @return the modal
     */
    public int getModal() {
        return modal;
    }

    /**
     * @param modal the modal to set
     */
    public void setModal(int modal) {
        this.modal = modal;
    }

    /**
     * @return the laba
     */
    public int getLaba() {
        return laba;
    }

    /**
     * @param laba the laba to set
     */
    public void setLaba(int laba) {
        this.laba = laba;
    }

    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }

    /**
     * @return the lama
     */
    public int getLama() {
        return lama;
    }

    /**
     * @param lama the lama to set
     */
    public void setLama(int lama) {
        this.lama = lama;
    }

    /**
     * @return the dp
     */
    public int getDp() {
        return dp;
    }

    /**
     * @param dp the dp to set
     */
    public void setDp(int dp) {
        this.dp = dp;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the cicilan
     */
    public int getCicilan() {
        return cicilan;
    }

    /**
     * @param cicilan the cicilan to set
     */
    public void setCicilan(int cicilan) {
        this.cicilan = cicilan;
    }

    /**
     * @return the stpengajuan
     */
    public String getStpengajuan() {
        return stpengajuan;
    }

    /**
     * @param stpengajuan the stpengajuan to set
     */
    public void setStpengajuan(String stpengajuan) {
        this.stpengajuan = stpengajuan;
    }

    /**
     * @return the stpembayaran
     */
    public String getStpembayaran() {
        return stpembayaran;
    }

    /**
     * @param stpembayaran the stpembayaran to set
     */
    public void setStpembayaran(String stpembayaran) {
        this.stpembayaran = stpembayaran;
    }

    /**
     * @return the update
     */
    public String getUpdate() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(String update) {
        this.update = update;
    }

    public ModelTable(int id, String no, String nasabah, String tppengajuan, String barang, String tpbarang, int modal, int laba, int total, int lama, int dp, String date, int cicilan, String stpengajuan, String stpembayaran, String update) {
        this.id = id;
        this.no = no;
        this.nasabah = nasabah;
        this.tppengajuan = tppengajuan;
        this.barang = barang;
        this.tpbarang = tpbarang;
        this.modal = modal;
        this.laba = laba;
        this.total = total;
        this.lama = lama;
        this.dp = dp;
        this.date = date;
        this.cicilan = cicilan;
        this.stpengajuan = stpengajuan;
        this.stpembayaran = stpembayaran;
        this.update = update;
    }

    public ModelTable() {
    }
    
    private int id;
    private String no;
    private String nasabah;
    private String tppengajuan;
    private String barang;
    private String tpbarang;
    private int modal;
    private int laba;
    private int total;
    private int lama;
    private int dp;
    private String date;
    private int cicilan;
    private String stpengajuan;
    private String stpembayaran;
    private String update;
    
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, nasabah, tppengajuan, barang, tpbarang, modal, laba, total, lama, dp, date, cicilan, stpengajuan, stpembayaran, update, new ModelAction(this, event)};
    }
}
