package Kata01;

public class PageData {

    private String content;

    public WikiPage getWikiPage() {
        return new WikiPage();
    }

    public boolean hasAttribute(String test) {
        return false;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return " ";
    }
}
