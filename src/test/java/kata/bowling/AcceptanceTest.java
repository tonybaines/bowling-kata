package kata.bowling;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class AcceptanceTest {
    @Test
    public void shouldScoreAPoorGameOfBowling() {
        BowlingGame game = new BowlingGame();
        for (int i=1; i <= 20; i++) {
            game.bowl(1);
        }
        assertEquals(20, game.score());
    }
}
