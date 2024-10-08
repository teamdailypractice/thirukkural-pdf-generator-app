package info.dailypractice.entity;

// Class for individual hyperlink
public class HyperlinkWithDescription extends Hyperlink{
    private int count;

    public HyperlinkWithDescription() {
    }

    public HyperlinkWithDescription(String text, String url, int count) {
        super(text, url);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "HyperlinkWithDescription{" +
               super.toString() +
               "count='" + count + '\'' +
               '}';
    }
}

// Class to hold the list of hyperlinks

