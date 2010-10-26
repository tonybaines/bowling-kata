package kata.bowling;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;

public class BowlingGameTest {
  private BowlingGame game = new BowlingGame();

  @Test
  public void shouldScoreAGameOfOneFrameWhereNotAllPinsAreKnockedDown() {
    game.bowl(5);
    game.bowl(4);
    bowlNoScoreFrames(9);
    assertEquals(9, game.score());
  }

  @Test
  public void shouldScoreAGameWhereOnlyOnePinIsKnockedDownWithEachBowl() {
    bowlManyTimes(1, 20);
    assertEquals(20, game.score());
  }

  @Test
  public void shouldScoreAFrameWhereAllThePinsAreKnockedDownByTheFirstBall() {
    game.bowl(10);
    bowlNoScoreFrames(9);
    assertEquals(10, game.score());
  }

  @Test
  public void shouldScoreAPairOfFramesWhereAStrikeIsFollowedByJustOneKnockedDownInTheNext() {
    game.bowl(10);
    game.bowl(1);
    game.bowl(0);
    bowlNoScoreFrames(8);
    assertEquals(12, game.score());
  }

  @Test
  public void shouldScoreAPairOfFramesWhereASpareIsFollowedByJustOneKnockedDownInTheFirstBallOfTheNext() {
    game.bowl(5);
    game.bowl(5);
    game.bowl(1);
    game.bowl(0);
    bowlNoScoreFrames(8);
    assertEquals(12, game.score());
  }

  @Test
  public void shouldScoreAPairOfFramesWhereASpareIsFollowedByJustOneKnockedDownInTheSecondBallOfTheNext() {
    game.bowl(5);
    game.bowl(5);
    game.bowl(0);
    game.bowl(1);
    bowlNoScoreFrames(8);
    assertEquals(11, game.score());
  }

  @Test
  public void shouldScoreAGameWhereNineStrikesAreBowledInARow() {
    bowlManyTimes(10, 9);
    bowlNoScoreFrames(1);
    assertEquals(240, game.score());
  }

  @Test
  public void shouldScoreAGameWhereThirteenStrikesAreBowledInARow() {
    bowlManyTimes(10, 13);
    assertEquals(300, game.score());
  }

  private void bowlManyTimes(int score, int times) {
    for (int i = 1; i <= times; i++) {
      game.bowl(score);
    }
  }

  private void bowlNoScoreFrames(int times) {
    bowlManyTimes(0, 2*times);
  }
}
