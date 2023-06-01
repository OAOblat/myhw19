import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Player player1 = new Player(1, "Valera", 37);
    Player player2 = new Player(2, "Alex", 0);
    Player player3 = new Player(3, "Anna", 5);
    Player player4 = new Player(4, "Olya", 75);
    Player player5 = new Player(5, "Maria", 1);
    Player player6 = new Player(6, "Kirill", 1);

    @Test
    public void shouldWinFirstPlayer() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);
        int actual = 1;
        int expected = game.round("Valera", "Alex");
        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void shouldWinSecondPlayer() {

        Game game = new Game();
        game.register(player3);
        game.register(player4);
        int actual = 2;
        int expected = game.round("Anna", "Olya");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenWinNoPlayer() {

        Game game = new Game();
        game.register(player5);
        game.register(player6);
        int actual = 0;
        int expected = game.round("Maria", "Kirill");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldTestWhenFirstPlayerIsNone() {

        Game game = new Game();
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Alisa", "Kirill"));

    }

    @Test
    public void shouldTestWhenSecondPlayerIsNone() {

        Game game = new Game();
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Maria", "Alisa"));

    }

    @Test
    public void shouldTestWhenTwoPlayerIsNone() {

        Game game = new Game();
        game.register(player5);
        game.register(player6);

        Assertions.assertThrows(NotRegisteredException.class, () ->
                game.round("Sergey", "Alisa"));

    }
}
