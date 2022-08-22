package resources.views.page.investor.table.main;

public class ModelTable {

    /**
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * @param job the job to set
     */
    public void setJob(String job) {
        this.job = job;
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
    public String getNik() {
        return nik;
    }

    /**
     * @param nik the nik to set
     */
    public void setNik(String nik) {
        this.nik = nik;
    }    

    /**
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }

    public ModelTable(int id, int no, String name, String nik, String job, String company) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.nik = nik;
        this.job = job;
        this.company = company;
    }

    public ModelTable() {
    }

    private int id;
    private int no;
    private String name;
    private String nik;
    private String job;
    private String company;
    
    public Object[] toRowTable(EventAction event) {
        return new Object[] {no, name, nik, job, company, new ModelAction(this, event)};
    }
}
