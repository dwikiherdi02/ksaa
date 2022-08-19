package resources.views.page.karyawan.table;

public class ModelAction {

    /**
     * @return the karyawan
     */
    public ModelTable getKaryawan() {
        return karyawan;
    }

    /**
     * @param karyawan the karyawan to set
     */
    public void setKaryawan(ModelTable karyawan) {
        this.karyawan = karyawan;
    }

    /**
     * @return the event
     */
    public EventAction getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(EventAction event) {
        this.event = event;
    }

    public ModelAction(ModelTable karyawan, EventAction event) {
        this.karyawan = karyawan;
        this.event = event;
    }
    
    public ModelAction() {
    }
    
    private ModelTable karyawan;
    private EventAction event;
}
