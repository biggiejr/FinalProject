package core.DBproject;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Costica 08/05/2017.
 */
public class testFunctionality {

    @Test
    public void testFunctionality() {
        assertEquals(10, functionality.giveMeTen());
    }

}