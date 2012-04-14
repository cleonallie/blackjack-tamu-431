package testing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BlackJackCardTest.class, DeckTest.class, PlayerTest.class, BlackJackGameTest.class })
public class AllTests {

}
