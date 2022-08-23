package resources.views.page.pengajuan.table;


public class ModelTable {

    /**
     * @return the status_pengajuan_id
     */
    public int getStatus_pengajuan_id() {
        return status_pengajuan_id;
    }

    /**
     * @param status_pengajuan_id the status_pengajuan_id to set
     */
    public void setStatus_pengajuan_id(int status_pengajuan_id) {
        this.status_pengajuan_id = status_pengajuan_id;
    }

    /**
     * @return the total_paid
     */
    public int getTotal_paid() {
        return total_paid;
    }

    /**
     * @param total_paid the total_paid to set
     */
    public void setTotal_paid(int total_paid) {
        this.total_paid = total_paid;
    }

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
     * @return the no_pengajuan
     */
    public String getNo_pengajuan() {
        return no_pengajuan;
    }

    /**
     * @param no_pengajuan the no_pengajuan to set
     */
    public void setNo_pengajuan(String no_pengajuan) {
        this.no_pengajuan = no_pengajuan;
    }

    /**
     * @return the status_pengajuan
     */
    public String getStatus_pengajuan() {
        return status_pengajuan;
    }

    /**
     * @param status_pengajuan the status_pengajuan to set
     */
    public void setStatus_pengajuan(String status_pengajuan) {
        this.status_pengajuan = status_pengajuan;
    }

    /**
     * @return the status_pembiayaan
     */
    public String getStatus_pembiayaan() {
        return status_pembiayaan;
    }

    /**
     * @param status_pembiayaan the status_pembiayaan to set
     */
    public void setStatus_pembiayaan(String status_pembiayaan) {
        this.status_pembiayaan = status_pembiayaan;
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
     * @return the tipe_pengajuan
     */
    public String getTipe_pengajuan() {
        return tipe_pengajuan;
    }

    /**
     * @param tipe_pengajuan the tipe_pengajuan to set
     */
    public void setTipe_pengajuan(String tipe_pengajuan) {
        this.tipe_pengajuan = tipe_pengajuan;
    }

    /**
     * @return the tipe_barang
     */
    public String getTipe_barang() {
        return tipe_barang;
    }

    /**
     * @param tipe_barang the tipe_barang to set
     */
    public void setTipe_barang(String tipe_barang) {
        this.tipe_barang = tipe_barang;
    }

    /**
     * @return the nama_barang
     */
    public String getNama_barang() {
        return nama_barang;
    }

    /**
     * @param nama_barang the nama_barang to set
     */
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
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
     * @return the est_laba
     */
    public String getEst_laba() {
        return est_laba;
    }

    /**
     * @param est_laba the est_laba to set
     */
    public void setEst_laba(String est_laba) {
        this.est_laba = est_laba;
    }

    /**
     * @return the total
     */
    public String getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(String total) {
        this.total = total;
    }

    /**
     * @return the dp
     */
    public String getDp() {
        return dp;
    }

    /**
     * @param dp the dp to set
     */
    public void setDp(String dp) {
        this.dp = dp;
    }

    /**
     * @return the dp_date
     */
    public String getDp_date() {
        return dp_date;
    }

    /**
     * @param dp_date the dp_date to set
     */
    public void setDp_date(String dp_date) {
        this.dp_date = dp_date;
    }

    /**
     * @return the cicilan
     */
    public String getCicilan() {
        return cicilan;
    }

    /**
     * @param cicilan the cicilan to set
     */
    public void setCicilan(String cicilan) {
        this.cicilan = cicilan;
    }

    /**
     * @return the total_angsuran
     */
    public String getTotal_angsuran() {
        return total_angsuran;
    }

    /**
     * @param total_angsuran the total_angsuran to set
     */
    public void setTotal_angsuran(String total_angsuran) {
        this.total_angsuran = total_angsuran;
    }

    public ModelTable(int id, int status_pengajuan_id, int total_paid, String no_pengajuan, String status_pengajuan, String status_pembiayaan, String nasabah, String tipe_pengajuan, String tipe_barang, String nama_barang, String modal, String est_laba, String total, String dp, String dp_date, String cicilan, String total_angsuran) {
        this.id = id;
        this.status_pengajuan_id = status_pengajuan_id;
        this.total_paid = total_paid;
        this.no_pengajuan = no_pengajuan;
        this.status_pengajuan = status_pengajuan;
        this.status_pembiayaan = status_pembiayaan;
        this.nasabah = nasabah;
        this.tipe_pengajuan = tipe_pengajuan;
        this.tipe_barang = tipe_barang;
        this.nama_barang = nama_barang;
        this.modal = modal;
        this.est_laba = est_laba;
        this.total = total;
        this.dp = dp;
        this.dp_date = dp_date;
        this.cicilan = cicilan;
        this.total_angsuran = total_angsuran;
    }

    

    public ModelTable() {
    }
    
    private int id;
    private int status_pengajuan_id;
    private int total_paid;
    private String no_pengajuan;
    private String status_pengajuan;
    private String status_pembiayaan;
    private String nasabah;
    private String tipe_pengajuan;
    private String tipe_barang;
    private String nama_barang;
    private String modal;
    private String est_laba;
    private String total;
    private String dp;
    private String dp_date;
    private String cicilan;
    private String total_angsuran;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {
            no_pengajuan,
            status_pengajuan,
            status_pembiayaan,
            nasabah,
            tipe_pengajuan,
            tipe_barang,
            nama_barang,
            modal,
            est_laba,
            total,
            dp,
            dp_date,
            cicilan,
            total_angsuran,
            new ModelAction(this, event)
        };
    }
}
