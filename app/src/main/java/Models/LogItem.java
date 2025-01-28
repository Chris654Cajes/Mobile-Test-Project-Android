package Models;

/*
    This is a structure for a log
*/

public class LogItem {
    private int id, buttonNumber;
    private String eventTimeStamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getButtonNumber() {
        return buttonNumber;
    }

    public void setButtonNumber(int buttonNumber) {
        this.buttonNumber = buttonNumber;
    }

    public String getEventTimeStamp() { return eventTimeStamp; }

    public void setEventTimeStamp(String eventTimeStamp) { this.eventTimeStamp = eventTimeStamp; }
}
