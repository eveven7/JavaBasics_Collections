package HomeWork;

import java.util.*;

public class GameTasks {
    public static void main(String[] args) {
        Game game1 = new Game("Double Dragon", Genre.ACTION, 102, 1011);
        Game game2 = new Game("Fortnite", Genre.BATTLE, 89, 1088);
        Game game3 = new Game("Street Fighter", Genre.FIGHTING, 39, 5898);
        Game game4 = new Game("Fifa", Genre.SPORTS, 19, 3339);

        List<Game> games = new ArrayList<>();
        games.add(game1);
        games.add(game2);
        games.add(game3);
        games.add(game4);

        System.out.println("3. Use foreach to go through array of games and print it:");

        for (Game game : games) {
            System.out.println("\nList of games" + "\n" + Arrays.toString(games.toArray()));
        }

        System.out.println(" ");
        System.out.println("4. Remove second game and move Printing to the method and print list again :");

        games.remove(1);

        printing(games);

        System.out.println("6. Implement PriceComparator and sort Games by Price ascending :");

        Collections.sort(games, new PriceComparator());
        printing(games);

        System.out.println("Sort Games by Price descending:");

        Collections.sort(games, new PriceComparator().reversed());
        printing(games);

        System.out.println("1. Using Streams ForEach method increment price:");

        games.stream().forEach(game -> game.incrementPrice(30));
        Collections.sort(games, new PriceComparator());
        printing(games);

        System.out.println("3. Using Stream Filter games by price (more than 10 euros) and copies sold (more than 50):");

        List<Game> priceSold = games.stream().filter(game -> game.getPrice() > 10).filter(game -> game.getCopiesSold() > 50).toList();
        printing(priceSold);

        System.out.println("1. Using Streams Sorted sort Games by copies sold:");

        List<Game> sortedGames = games.stream().sorted(Comparator.comparingInt(Game::getCopiesSold)).toList();
        printing(sortedGames);

        System.out.println("2. Streams Min/Max :");

        Optional<Game> minCopiesSold = games.stream().min(Comparator.comparingInt(Game::getCopiesSold));
        System.out.println("Games that sold minimum copies: \n" + minCopiesSold);

        Optional<Game> maxCopiesSold = games.stream().max(Comparator.comparingInt(Game::getCopiesSold));
        System.out.println("Games that sold maximum copies: \n" + maxCopiesSold);
    }

    /**
     * Printing method
     */
    private static void printing(List<Game> games) {
        for (Game game : games) {
            System.out.println(game.toString() + "\n");
        }
    }
}
