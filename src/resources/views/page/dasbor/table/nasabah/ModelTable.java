package resources.views.page.dasbor.table.nasabah;

public class ModelTable {

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the nominal
     */
    public String getNominal() {
        return nominal;
    }

    /**
     * @param nominal the nominal to set
     */
    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public ModelTable(int no, String name, String nominal) {
        this.no = no;
        this.name = name;
        this.nominal = nominal;
    }

    public ModelTable() {
    }
    
    private int no;
    private String name;
    private String nominal;
    
    public Object[] toRowTable() {
        return new Object[] {no, name, nominal};
    }
}
