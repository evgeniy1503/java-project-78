package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    public static final int NUMBER_ELEVEN = 11;
    public static final int NUMBER_TEN = 10;
    public static final int NUMBER_NINE = 9;
    public static final int NUMBER_SIX = 6;
    public static final int NUMBER_FIVE = 5;

    @Test
    public void testString() {

        Validator v = new Validator();
        StringSchema schema = v.string();

        var actual1 = schema.isValid("");
        assertThat(actual1).isTrue();

        var actual2 = schema.isValid(null);
        assertThat(actual2).isTrue();

        schema.required();
        var actual3 = schema.isValid("what does the fox say");
        assertThat(actual3).isTrue();

        var actual4 = schema.isValid(null);
        assertThat(actual4).isFalse();

        schema.minLength(2);
        var actual5 = schema.isValid("Evgeniy");
        assertThat(actual5).isTrue();

        var actual6 = schema.isValid("E");
        assertThat(actual6).isFalse();

        var actual7 = schema.contains("what").isValid("what does the fox say");
        assertThat(actual7).isTrue();

        var actual8 = schema.contains("wh").isValid("what does the fox say");
        assertThat(actual8).isTrue();

        var actual9 = schema.contains("whatthe").isValid("what does the fox say");
        assertThat(actual9).isFalse();

        var actual10 = schema.isValid("what does the fox say");
        assertThat(actual10).isFalse();

    }

    @Test
    public void testNumber() {

        Validator v = new Validator();
        NumberSchema schema = v.number();

        var actual1 = schema.isValid(1);
        assertThat(actual1).isTrue();

        var actual2 = schema.isValid(null);
        assertThat(actual2).isTrue();


        var actual3 = schema.positive().isValid(null);
        assertThat(actual3).isTrue();

        schema.required();
        var actual4 = schema.isValid("5");
        assertThat(actual4).isFalse();

        var actual5 = schema.isValid(null);
        assertThat(actual5).isFalse();

        var actual6 = schema.positive().isValid(1);
        assertThat(actual6).isTrue();

        var actual7 = schema.isValid(-1);
        assertThat(actual7).isFalse();

        schema.range(2, NUMBER_TEN);
        var actual8 = schema.isValid(2);
        assertThat(actual8).isTrue();

        var actual9 = schema.isValid(NUMBER_TEN);
        assertThat(actual9).isTrue();

        var actual10 = schema.isValid(NUMBER_ELEVEN);
        assertThat(actual10).isFalse();

        var actual11 = schema.isValid(-1);
        assertThat(actual11).isFalse();

        schema.range(NUMBER_SIX, NUMBER_NINE);
        var actual12 = schema.isValid(NUMBER_FIVE);
        assertThat(actual12).isFalse();

        var actual13 = schema.isValid(NUMBER_TEN);
        assertThat(actual13).isFalse();
    }

    @Test
    public void testMapSchema() {

        Validator v = new Validator();
        MapSchema schema = v.map();

        var actual = schema.isValid(null);
        assertThat(actual).isTrue();
        var actual11 = schema.isValid(new HashMap<>());
        assertThat(actual11).isTrue();

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

    @Test
    public void testMapSchemaShape() {

        Validator v = new Validator();
        MapSchema schema = v.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        schemas.put("name", v.string().required());
        schemas.put("age", v.number().positive());
        schema.shape(schemas);

        Map<String, Object> human1 = new HashMap<>();
        human1.put("name", "Kolya");
        human1.put("age", 1);
        var actual = schema.isValid(human1);
        assertThat(actual).isTrue();

        Map<String, Object> human2 = new HashMap<>();
        human2.put("name", "Maya");
        human2.put("age", null);
        var actual2 = schema.isValid(human2);
        assertThat(actual2).isTrue();

        Map<String, Object> human3 = new HashMap<>();
        human3.put("name", "");
        human3.put("age", null);
        var actual3 = schema.isValid(human3);
        assertThat(actual3).isFalse();

        Map<String, Object> human4 = new HashMap<>();
        human3.put("name", "Maya");
        human3.put("age", -1);
        var actual4 = schema.isValid(human3);
        assertThat(actual4).isFalse();

    }

}
