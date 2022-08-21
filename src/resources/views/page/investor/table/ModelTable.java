package resources.views.page.investor.table;

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
     * @return the nik
     */
    public int getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(int nik) {
        this.nik = nik;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
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

    public ModelTable(int id, int no, String name, int nik, String address, int total) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.nik = nik;
        this.address = address;
        this.total = total;
    }

    public ModelTable() {
    }
    
    private int id;
    private int no;
    private String name;
    private int nik;
    private String address;
    private int total;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, name, nik, address, total, new ModelAction(this, event)};
    }
}
