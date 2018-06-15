package conganh.hcmus;

import java.io.Serializable;

public abstract class Document implements Serializable {
    protected String documentID;
    protected String publisher;
    protected int numPublishing;

    public Document() {
    }

    public Document(String documentID, String publisher, int numPublishing) {
        this.documentID = documentID;
        this.publisher = publisher;
        this.numPublishing = numPublishing;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumPublishing() {
        return numPublishing;
    }

    public void setNumPublishing(int numPublishing) {
        this.numPublishing = numPublishing;
    }

    @Override
    public abstract String toString();
}
