package conganh.hcmus;

import java.io.Serializable;

public class Newspaper extends Document implements Serializable {
    private String releaseDay;

    public Newspaper(String documentID, String publisher, int numPublishing, String releaseDay) {
        super(documentID, publisher, numPublishing);
        this.releaseDay = releaseDay;
    }

    public String getReleaseDay() {
        return releaseDay;
    }

    public void setReleaseDay(String releaseDay) {
        this.releaseDay = releaseDay;
    }

    @Override
    public String toString() {
        return "\n-------Newspaper ------"
                +"\nDocument ID: " + documentID
                + "\nPublisher: " + publisher
                + "\nNumPublishing: " + numPublishing
                + "\nRelease Day: " + releaseDay;
    }
}
