package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    @Test
    public void testStringSchemaIsEmpty() {

        Validator v = new Validator();
        StringSchema schema = v.string();
        var actual = schema.isValid("");
        assertThat(actual).isTrue();
        var actual2 = schema.isValid(null);
        assertThat(actual2).isTrue();

    }
    @Test
    public void testStringSchema() {

        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.isValid("what does the fox say");
        assertThat(actual).isTrue();
        var actual2 = schema.isValid("");
        assertThat(actual2).isFalse();

    }

    @Test
    public void testStringSchemaContains() {

        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        var actual = schema.contains("what").isValid("what does the fox say");
        assertThat(actual).isTrue();
        var actual2 = schema.contains("wh").isValid("what does the fox say");
        assertThat(actual2).isTrue();


    }
}
