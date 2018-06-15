package conganh.hcmus;

import java.io.Serializable;

public class Book extends Document implements Serializable {
    private String authorName;
    private int numPage;

    public Book(String documentID, String publisher, int numPublishing, String authorName, int numPage) {
        super(documentID, publisher, numPublishing);
        this.authorName = authorName;
        this.numPage = numPage;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String autherName) {
        this.authorName = autherName;
    }

    public int getNumPage() {
        return numPage;
    }

    public void setNumPage(int numPage) {
        this.numPage = numPage;
    }

    @Override
    public String toString() {
        return "------------Book----------"
                +"\nDocument ID: " + documentID
                + "\nPublisher: " + publisher
                + "\nNumPublishing: " + numPublishing
                + "\nAuther Name: " + authorName
                + "\nNumPage: " + numPage;
    }
}
