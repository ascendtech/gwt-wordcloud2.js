# gwt-wordcloud2.js

GWT Wrapper for [wordcloud2.js](https://github.com/timdream/wordcloud2.js)

## Getting Started

### Gradle

Add AST Maven Repo

```gradle
  allprojects {
    repositories {
      ...
      maven { url 'https://maven.ascend-tech.us/repo' }
    }
  }
```

Add Dependency:

```gradle
  compile 'us.ascendtech:gwt-wordcloud2js:2.1.0'
  compile 'us.ascendtech:gwt-wordcloud2js:2.1.0:sources'
```

### Gradle Kotlin

Add AST Maven Repo

```gradle
  allprojects {
    repositories {
        ...
        maven {
            url = uri("https://maven.ascend-tech.us/repo")
        }
    }
  }
```

Add Dependency

```gradle
  compile("us.ascendtech:gwt-wordcloud2js:2.0.0")
  compile("us.ascendtech:gwt-wordcloud2js:2.0.0:sources")
```

### Example in Java

Add dependency to gwt.xml:

```xml

<inherits name="us.ascendtech.highcharts.Highcharts"/>
```

```java
// generate data object
JsArray<JsArray<Object>> data = new JsArray<>();
for (Term term:Elements.elements(terms)) {
	data.push(new JsArray<>(term.getTerm(),term.getWeight()));
}

// create options object and set the data.
WordCloud2JSOptions options=new WordCloud2JSOptions().setList(data).setFontFamily("Calibri, sans-serif").setRotateRatio(0.1);
options.setClick(item->DomGlobal.console.log(item));
options.setWeightFactor(2d);
options.setGridSize(18d);
options.setDrawOutOfBound(false);
options.setShrinkToFit(true);

new WordCloud2JS(elementId,options);
```

Please check out the [gwt-examples](https://github.com/ascendtech/gwt-examples) project for a working example.
