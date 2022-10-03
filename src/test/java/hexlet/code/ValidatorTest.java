package hexlet.code;

//import hexlet.code.schemas.NumberSchema;
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
        schema.minLength(2);
        var actual3 = schema.isValid("Evgeniy");
        assertThat(actual3).isTrue();

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

    @Test
    public void testStringSchemaLeLength() {

        Validator v = new Validator();
        StringSchema schema = v.string();
        schema.required();
        schema.minLength(2);
        var actual = schema.isValid("Hello, World");
        assertThat(actual).isTrue();
        var actual2 = schema.isValid("H");
        assertThat(actual2).isFalse();

    }

//    @Test
//    public void testNumber() {
//
//        Validator v = new Validator();
//        NumberSchema schema = v.number();
//        var actual = schema.isValid(null);
//        assertThat(actual).isTrue();
//        schema.required();
//        var actual2 = schema.isValid(null);
//        assertThat(actual2).isFalse();
//        var actual3 = schema.positive().isValid(10);
//        assertThat(actual3).isTrue();
//        var actual4 = schema.isValid(-10);
//        assertThat(actual4).isFalse();
//
//
//    }
}
