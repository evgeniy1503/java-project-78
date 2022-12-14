### Data Validation Tool:
[![Actions Status](https://github.com/evgeniy1503/java-project-78/workflows/hexlet-check/badge.svg)](https://github.com/evgeniy1503/java-project-78/actions)
[![Java CI](https://github.com/evgeniy1503/java-project-78/actions/workflows/workflows.yml/badge.svg)](https://github.com/evgeniy1503/java-project-78/actions/workflows/workflows.yml)
<a href="https://codeclimate.com/github/evgeniy1503/java-project-78/maintainability"><img src="https://api.codeclimate.com/v1/badges/2ed7174df2b8536e03fe/maintainability" /></a>
<a href="https://codeclimate.com/github/evgeniy1503/java-project-78/test_coverage"><img src="https://api.codeclimate.com/v1/badges/2ed7174df2b8536e03fe/test_coverage" /></a>

### About validation:

#### Validation of strings: 
<ul>
    <li><b>required</b> – любая непустая строка</li>
    <li><b>minLength</b> – строка равна или длиннее указанного числа</li>
    <li><b>contains</b> – строка содержит определённую подстроку</li>
</ul>

```sh
import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;

Validator v = new Validator();

StringSchema schema = v.string();

schema.isValid(""); // true
schema.isValid(null); // true

schema.required();

schema.isValid("what does the fox say"); // true
schema.isValid("hexlet"); // true
schema.isValid(null); // false
schema.isValid(""); // false

schema.contains("wh").isValid("what does the fox say"); // true
schema.contains("what").isValid("what does the fox say"); // true
schema.contains("whatthe").isValid("what does the fox say"); // false

schema.isValid("what does the fox say"); // false
// уже false, так как добавлена ещё одна проверка contains("whatthe")
```
#### Validation of numbers:

<ul>
    <li><b>required</b> – любое число включая ноль</li>
    <li><b>positive</b> – положительное число</li>
    <li><b>range</b> – диапазон, в который должны попадать числа включая границы</li>
</ul>

```sh
import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;

Validator v = new Validator();

NumberSchema schema = v.number();

schema.isValid(null); // true

schema.required();

schema.isValid(null); // false
schema.isValid(10) // true
schema.isValid("5"); // false

schema.positive().isValid(10); // true
schema.isValid(-10); // false

schema.range(5, 10);

schema.isValid(5); // true
schema.isValid(10); // true
schema.isValid(4); // false
schema.isValid(11); // false
```
#### Validation of Map type objects:

<ul>
    <li><b>required</b> – требуется тип данных Map</li>
    <li><b>sizeof</b> – количество пар ключ-значений в объекте Map должно быть равно заданному</li>
</ul>

```sh
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```

#### Nested verification:


```sh
import hexlet.code.Validator;
import hexlet.code.schemas.MapSchema;

Validator v = new Validator();

MapSchema schema = v.map();

schema.isValid(null); // true

schema.required();

schema.isValid(null) // false
schema.isValid(new HashMap()); // true
Map<String, String> data = new HashMap<>();
data.put("key1", "value1");
schema.isValid(data); // true

schema.sizeof(2);

schema.isValid(data);  // false
data.put("key2", "value2");
schema.isValid(data); // true
```