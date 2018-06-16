package conganh.hcmus;

import java.io.Serializable;

public class BlockC extends Student implements Serializable {
    private String literature;
    private String history;
    private String geography;

    public BlockC(int studentID, String fullName, String address, String prioritize, String literature, String history, String geography) {
        super(studentID, fullName, address, prioritize);
        this.literature = literature;
        this.history = history;
        this.geography = geography;
    }

    public String getLiterature() {
        return literature;
    }

    public void setLiterature(String literature) {
        this.literature = literature;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getGeography() {
        return geography;
    }

    public void setGeography(String geography) {
        this.geography = geography;
    }

    @Override
    public String toString() {
        return null;
    }
}
