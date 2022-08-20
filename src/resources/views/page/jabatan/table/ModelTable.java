package resources.views.page.jabatan.table;

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
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    public ModelTable(int id, int no, String name, String code) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.code = code;
    }

    public ModelTable() {
    }
    
    private int id;
    private int no;
    private String name;
    private String code;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, name, code, new ModelAction(this, event)};
    }
}
