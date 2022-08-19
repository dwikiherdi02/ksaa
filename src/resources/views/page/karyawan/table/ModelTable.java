package resources.views.page.karyawan.table;

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
     * @return the emp_id
     */
    public String getEmp_id() {
        return emp_id;
    }

    /**
     * @param emp_id the emp_id to set
     */
    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
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

    public ModelTable(int id, int no, String emp_id, String position, String name) {
        this.id = id;
        this.no = no;
        this.emp_id = emp_id;
        this.position = position;
        this.name = name;
    }
    
    public ModelTable() {
    }
    
    private int id;
    private int no;
    private String emp_id;
    private String position;
    private String name;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, emp_id, position, name, new ModelAction(this, event)};
    }
}
