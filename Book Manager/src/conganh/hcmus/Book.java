package conganh.hcmus;

import java.io.Serializable;

public class Book extends Document implements Serializable {
    private String autherName;
    private int numPage;

    public Book(String autherName, int numPage) {
        this.autherName = autherName;
        this.numPage = numPage;
    }

    public Book(String documentID, String publisher, int numPublishing, String autherName, int numPage) {
        super(documentID, publisher, numPublishing);
        this.autherName = autherName;
        this.numPage = numPage;
    }

    public String getAutherName() {
        return autherName;
    }

    public void setAutherName(String autherName) {
        this.autherName = autherName;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    @Override
    public String toString() {
        return "";
    }
}
