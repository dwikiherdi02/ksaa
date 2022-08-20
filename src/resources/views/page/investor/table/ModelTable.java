package resources.views.page.pengguna.table;

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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public ModelTable(int id, int no, String name, String username) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.username = username;
    }

    public ModelTable() {
    }
   
    private int id;
    private int no;
    private String name;
    private String username;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, name, username, new ModelAction(this, event)};
    }
}
