package data;

public class GistData {

    private static String gistDesc;
    private static String gistCont;

    public void setGistDesc(String gistDescription) {
        this.gistDesc = gistDescription;
    }

    public void setGistContent(String gistContent) {
        this.gistCont = gistContent;
    }

    public String getGistDesc() {
        return gistDesc;
    }

    public String getGistContent() {
        return gistCont;
    }
}
