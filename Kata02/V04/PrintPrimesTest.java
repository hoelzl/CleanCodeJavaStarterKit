package Kata02.V04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * This Test simply compares the output
 * with a previously saved report 'gold'
 * If the two match, then the test passes
 *
 * This is an example of a 'characterization test'
 * as described by Michael Feathers in his book
 * 'Working Effectively with Legacy Code'.
 * You save the ouput in a file. after that
 * you refactor the code and compare the
 * new oupt with the saved output.
 *
 * You write characterization tests when you
 * have a gob of legacy code that you want to refactor.
 *
 * The test helps you make sure
 * you haven't broken anything.
 */
public class PrintPrimesTest {
    private PrintStream out;

    @Before
    public void setup() throws Exception {
        out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("lead")));
    }

    @After
    public void teardown() {
        System.setOut(out);
        new File("lead").delete();
    }

    @Test
    public void makeSureOutputMatchesGold() throws Exception {
        PrimePrinter.main(new String[0]);
        BufferedReader lead = new BufferedReader(new FileReader("lead"));
        BufferedReader gold = new BufferedReader(new FileReader("gold"));
        String line;
        while ((line = gold.readLine()) != null)
            assertEquals(line, lead.readLine());
        assertEquals(null, lead.readLine());
    }
}
