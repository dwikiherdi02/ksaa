package resources.views.page.laporan.pembayaran.table;

import resources.views.page.laporan.lunas.table.*;

public class ModelTable {

    /**
     * @return the angsuranKe
     */
    public String getAngsuranKe() {
        return angsuranKe;
    }

    /**
     * @param angsuranKe the angsuranKe to set
     */
    public void setAngsuranKe(String angsuranKe) {
        this.angsuranKe = angsuranKe;
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
     * @return the notes
     */
    public String getNotes() {
        return notes;
    }

    /**
     * @param notes the notes to set
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ModelTable(String angsuranKe, String nominalCicilan, String tanggalBayar, String notes) {
        this.angsuranKe = angsuranKe;
        this.nominalCicilan = nominalCicilan;
        this.tanggalBayar = tanggalBayar;
        this.notes = notes;
    }

    public ModelTable() {
    }
   
    private String angsuranKe;
    private String nominalCicilan;
    private String tanggalBayar;
    private String notes;
    
    public Object[] toRowTable() {
        return new Object[] {angsuranKe, nominalCicilan, tanggalBayar, notes};
    }
}
