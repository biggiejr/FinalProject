package mappers;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Mato on 17.5.17.
 */
class SQLMapperTest {
    @Test
    void getBookByCity() {
        String measured= "Hello World";
        assertThat(measured, is(not("Hello")));
    }

    @Test
    void getMentionedCitiesByBook() {
    }

    @Test
    void getMentionedCitiesByAuthor() {
    }

    @Test
    void getAllBooksByCity() {
    }

}