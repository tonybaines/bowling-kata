package kata.bowling;

import static org.junit.Assert.*;

import org.junit.Test;


public class BowlingGameTest {
  @Test public void shouldScoreAGameOfOneFrameWhereNotAllPinsAreKnockedDown() {
    BowlingGame game = new BowlingGame();
    game.bowl(5);
    game.bowl(4);
    bowlNoScoreFrames(game, 9);
    assertEquals(9, game.score());
  }

  @Test public void shouldScoreAFrameWhereAllThePinsAreKnockedDownByTheFirstBall() {
    BowlingGame game = new BowlingGame();
    game.bowl(10);
    bowlNoScoreFrames(game, 9);
    assertEquals(10, game.score());
  }
  
  @Test public void shouldScoreAPairOfFramesWhereAStrikeIsFollowedByJustOneKnockedDownInTheNext() {
    BowlingGame game = new BowlingGame();
    game.bowl(10);
    game.bowl(1);
    game.bowl(0);
    bowlNoScoreFrames(game, 8);
    assertEquals(12, game.score());
  }
  
  @Test public void shouldScoreAPairOfFramesWhereASpareIsFollowedByJustOneKnockedDownInTheFirstBallOfTheNext() {
    BowlingGame game = new BowlingGame();
    game.bowl(5);
    game.bowl(5);
    game.bowl(1);
    game.bowl(0);
    bowlNoScoreFrames(game, 8);
    assertEquals(12, game.score());
  }

  @Test public void shouldScoreAPairOfFramesWhereASpareIsFollowedByJustOneKnockedDownInTheSecondBallOfTheNext() {
    BowlingGame game = new BowlingGame();
    game.bowl(5);
    game.bowl(5);
    game.bowl(0);
    game.bowl(1);
    bowlNoScoreFrames(game, 8);
    assertEquals(11, game.score());
  }
  
  @Test public void shouldScoreAGameWhereNineStrikesAreBowledInARow() {
    BowlingGame game = new BowlingGame();
    for (int i = 1; i <= 9; i++) {
      game.bowl(10);
    }
    bowlNoScoreFrames(game, 1);
    assertEquals(240, game.score());
  }
  
  @Test public void shouldScoreAGameWhereThirteenStrikesAreBowledInARow() {
    BowlingGame game = new BowlingGame();
    for (int i = 1; i <= 13; i++) {
      game.bowl(10);
    }
    assertEquals(300, game.score());
  }
  
  private void bowlNoScoreFrames(BowlingGame game, int noScoreFrames) {
    for(int i = 1; i <= noScoreFrames; i++) {
      game.bowl(0);
      game.bowl(0);
    }
  }
}
