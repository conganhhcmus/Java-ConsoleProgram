package conganh.hcmus;

import java.io.Serializable;

public class Magazine extends Document implements Serializable {
    private String releaseMonth;
    private int issueNumber;

    public Magazine(String releaseMonth, int issueNumber) {
        this.releaseMonth = releaseMonth;
        this.issueNumber = issueNumber;
    }

    public Magazine(String documentID, String publisher, int numPublishing, String releaseMonth, int issueNumber) {
        super(documentID, publisher, numPublishing);
        this.releaseMonth = releaseMonth;
        this.issueNumber = issueNumber;
    }

    public String getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(String releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        this.issueNumber = issueNumber;
    }

    @Override
    public String toString() {
        return "";
    }
}
