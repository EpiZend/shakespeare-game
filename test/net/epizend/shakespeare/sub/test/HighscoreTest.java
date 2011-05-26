package net.epizend.shakespeare.sub.test;

import java.util.ArrayList;
import java.util.List;
import net.epizend.shakespeare.sub.Reaction;
import net.epizend.shakespeare.sub.Score;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author epizend
 */
public class HighscoreTest {

    @Test
    public void testSerialization() {
        String username = "←$£]y03:','.";
        int score = 18357235;
        Score sc = new Score(score, username);
        String ser = sc.serializeScore();
        Score newScore = Score.deserialize(ser);
        assertEquals(sc, newScore);
    }

    @Test
    public void testHS() {
        String username = "←$£]y03:','.";
        int score = 18357235;
        Reaction react = new Reaction();
        List<Score> scores = new ArrayList<Score>();
        react.resetScore();
        for (int i = 0; i < 10; i++) {
            Score sc = new Score(score*i, username+"i");
            scores.add(sc);
            react.saveScore(sc);
        }
        List<Score> dez = react.getScores();
        for (int i = 0; i < scores.size(); i++) {
            Score sc = scores.get(i);
            assertTrue("Score "+i+" wasn't deserialized", dez.contains(sc));
        }
    }
}
