package yandetoday.test;

import org.junit.Test;
import yandetoday.YandeToday;

public class YandeTest {

    @Test
    public void test() {
        YandeToday yandeToday = YandeToday.newDay();
        yandeToday.saveMarkdown("piccuss.github.io/source/_posts/");
    }

}
