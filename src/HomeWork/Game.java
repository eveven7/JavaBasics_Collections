package HomeWork;


/**
 * Create a class Game with private modifies with getter setters of these fields:
 * String title
 * Enum genre
 * Double price
 * Integer copiesSold*/
public class Game {

    private String title;
    private Genre genre;
    private double price;
    private int copiesSold;

    public Game(String title, Genre genre, double price, int copiesSold) {
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.copiesSold = copiesSold;
    }

    public String getTitle() {
        return title;
    }

    public Genre getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCopiesSold(int copiesSold) {
        this.copiesSold = copiesSold;
    }

    public int getCopiesSold() {
        return copiesSold;
    }

    @Override
    public String toString() {
        return
                "\nTitle : " + title +
                "\nGenre :" + genre +
                "\nPrice : " + price +
                "\nCopiesSold : " + copiesSold + "\n";
    }

    public void incrementPrice(double increment) {
        price = price + increment;
    }
}
