package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        var actual = schema.contains("what").isValid("what does the fox say");
        assertThat(actual).isTrue();

        var actual2 = schema.contains("wh").isValid("what does the fox say");
        assertThat(actual2).isTrue();

    }

    @Test
    public void testStringSchemaLength() {

        Validator v = new Validator();
        StringSchema schema = v.string();

        schema.required();
        schema.minLength(2);
        var actual = schema.isValid("Hello, World");
        assertThat(actual).isTrue();

        var actual2 = schema.isValid("H");
        assertThat(actual2).isFalse();

    }

    @Test
    public void testNumberEmpty() {

        Validator v = new Validator();
        NumberSchema schema = v.number();

        var actual = schema.isValid(null);
        assertTrue(actual, "Error");

        schema.required();
        var actual2 = schema.isValid("5");
        assertThat(actual2).isFalse();
    }

    @Test
    public void testNumbers() {

        Validator v = new Validator();
        NumberSchema schema = v.number();

        schema.required();
        var actual2 = schema.isValid(null);
        assertThat(actual2).isFalse();

        var actual3 = schema.positive().isValid(1);
        assertThat(actual3).isTrue();

        var actual4 = schema.isValid(-1);
        assertThat(actual4).isFalse();

        schema.range(-1, 1);
        var actual5 = schema.isValid(0);
        assertThat(actual5).isTrue();

        var actual6 = schema.isValid(2);
        assertThat(actual6).isFalse();


    }

    @Test
    public void testMapSchema() {

        Validator v = new Validator();
        MapSchema schema = v.map();

        var actual = schema.isValid(null);
        assertThat(actual).isTrue();

        schema.required();
        var actual2 = schema.isValid(null);
        assertThat(actual2).isFalse();

        var actual3 = schema.isValid(new HashMap<>());
        assertThat(actual3).isTrue();

        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        var actual4 = schema.isValid(data);
        assertThat(actual4).isTrue();

        schema.sizeof(2);
        var actual5 = schema.isValid(data);
        assertThat(actual5).isFalse();

        data.put("key2", "value2");
        var actual6 = schema.isValid(data);
        assertThat(actual6).isTrue();
    }

}
