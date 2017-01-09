package learning;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:alexandru.burghelea@adswizz.com">Alexandru BURGHELEA</a>
 * @since 23/05/16
 */
public class IdManagerTest {

    @Test
    public void testName() throws Exception {

        run("http://build.adswizz.com/VLLT/havas-ads/728x90_TEST_260215.swf");
        run("http://cdn1-creatives.devel.adswizz.com/releases27/citroen10sstereo_ad_55535cb477dc9_1431526580.mp3");
        run("e716138454feab821396c1f8e5c17d2");
        run("8f3c1c3c06f0edbab811a1b4a0a4ba");
        run("a8c36b447c781db51a95cfc2233ec");
    }

    private void run(String input) {
        System.out.println(input +" ==> " + IdManager.md5(input));
    }
}