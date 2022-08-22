package resources.views.page.investor.table.stock;

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
     * @return the no_saham
     */
    public String getNo_saham() {
        return no_saham;
    }

    /**
     * @param no_saham the no_saham to set
     */
    public void setNo_saham(String no_saham) {
        this.no_saham = no_saham;
    }

    /**
     * @return the no_bukti
     */
    public String getNo_bukti() {
        return no_bukti;
    }

    /**
     * @param no_bukti the no_bukti to set
     */
    public void setNo_bukti(String no_bukti) {
        this.no_bukti = no_bukti;
    }

    /**
     * @return the buy_date
     */
    public String getBuy_date() {
        return buy_date;
    }

    /**
     * @param buy_date the buy_date to set
     */
    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    /**
     * @return the buy_price
     */
    public String getBuy_price() {
        return buy_price;
    }

    /**
     * @param buy_price the buy_price to set
     */
    public void setBuy_price(String buy_price) {
        this.buy_price = buy_price;
    }

    public ModelTable(int id, int no, String name, String no_saham, String no_bukti, String buy_date, String buy_price) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.no_saham = no_saham;
        this.no_bukti = no_bukti;
        this.buy_date = buy_date;
        this.buy_price = buy_price;
    }

    public ModelTable() {
    }
    
    private int id;
    private int no;
    private String name;
    private String no_saham;
    private String no_bukti;
    private String buy_date;
    private String buy_price;
    
//    public Object[] toRowTable(EventAction event) {
    public Object[] toRowTable() {
        return new Object[] {no, name, no_saham, no_bukti, buy_date, buy_price};
    }
}
