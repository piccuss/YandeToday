package yandetoday.test;

import org.junit.Test;
import yandetoday.YandeToday;

public class YandeTest {

    @Test
    public void test() {
        YandeToday yandeToday = YandeToday.newDay();
        yandeToday.saveMarkdown("github.piccuss.io/source/_posts/");
    }

}
