package be.ben.tinkin;

/**
 * A fact is composed of two parts: a text and a category
 *
 * @author Benoit Dupont
 */
public class Fact {
    private final String text;
    private final String category;

    public Fact(String text, String category) {
        this.text = text;
        this.category = category;
    }

    public String getText() {
        return text;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "text='" + text + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
