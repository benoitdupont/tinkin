package be.ben.tinkin;

/**
 * A fact is composed of two parts: a text and a category
 *
 * @author Benoit Dupont
 */
public class Fact {
    private final String text;
    private final String category;

    // TODO vastly file specific !
    public Fact(String line) {
        String[] tokens = line.split(";");
        if(tokens.length != 2){
            throw new IllegalArgumentException("There should be only two arguments and not " + tokens.length);
        }

        this.text = tokens[0].trim();
        this.category = tokens[1].trim();
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
