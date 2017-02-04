Test: Thymeleaf nested conversion with SpringEL
=======================================

This repository checks a reported change in behaviour for the conversion (via a Spring `Formatter`) of a nested property, depending on whether the property is declared in the containing bean as of being of its specific type, or a superclass (which has no registered `Formatter`).

See thymeleaf/thymeleaf-spring#128

### Contents

This repository contains two folders with almost exactly the same application code, except one of them uses Thymeleaf 2.1.5 and the other one Thymeleaf 3.0.3.

Both applications are based on Spring Boot 1.4.3.

The Thymeleaf 2.1.5 app starts on port `8080`. The Thymeleaf 3.0.3 app starts on port `8081`, so they can be started at the same time.

Both apps can be started with:

```
$ mvn -U clean compile spring-boot:run
```

### Implementation

The `Bean` class contains two fields:

```java
    private AbstractField fieldAbs = null;
    private Field fieldConc = null;
```

The `Field` class extends `AbstractField`. At the controller a `bean` variable of this `Bean` class is initialised as:

```java
    @RequestMapping("/")
    public String main(final Model model) {

        final Bean bean = new Bean();
        bean.setFieldAbs(new Field(100));
        bean.setFieldConc(new Field(500));

        model.addAttribute("bean", bean);

        return "main";

    }
```

Using a browser and pointing to the root of the web apps, the `main.html` template will show all the possible combinations for SpringEL conversion being applied:

```html
<section>
    <h3>Outside Form</h3>
    <p>Abstract Field: </p>
    <ul>
        <li>Without <kdb>th:object</kdb>: <span th:text="${{bean.fieldAbs}}">...</span></li>
        <li th:object="${bean}">With <kdb>th:object</kdb>: <span th:text="*{{fieldAbs}}">...</span></li>
    </ul>
    <p>Concrete Field: </p>
    <ul>
        <li>Without <kdb>th:object</kdb> <span th:text="${{bean.fieldConc}}">...</span></li>
        <li th:object="${bean}">With <kdb>th:object</kdb> <span th:text="*{{fieldConc}}">...</span></li>
    </ul>
</section>

<section>
    <h3>Inside Form</h3>
    <form th:object="${bean}">
        <fieldset>
            <p>
                <label for="fieldAbs">Abstract field:</label>
                <input th:field="*{fieldAbs}" />
            </p>
            <p>
                <label for="fieldConc">Concrete field:</label>
                <input th:field="*{fieldConc}" />
            </p>
        </fieldset>
    </form>
</section>
```

Both applications **show the same results**, so the reported differences in behaviour between 2.1.5 and 3.0.3 could not be confirmed.