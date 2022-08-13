package system.library;

public class Session {

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

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void removeSession() {
        this.id = 0;
        this.name = "";
        this.username = "";
        this.email = "";
    }
    
    public Session() {
        this.id = 0;
        this.name = "";
        this.username = "";
        this.email = "";
    }
    
    private int id;
    private String name;
    private String username;
    private String email;
}
