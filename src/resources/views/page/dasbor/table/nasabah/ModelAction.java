package resources.views.page.dasbor.table.nasabah;

public class ModelAction {

    /**
     * @return the dataTable
     */
    public ModelTable getDataTable() {
        return dataTable;
    }

    /**
     * @param dataTable the dataTable to set
     */
    public void setDataTable(ModelTable dataTable) {
        this.dataTable = dataTable;
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

    public ModelAction(ModelTable dataTable, EventAction event) {
        this.dataTable = dataTable;
        this.event = event;
    }

    public ModelAction() {
    }
    
    private ModelTable dataTable;
    private EventAction event;
}
