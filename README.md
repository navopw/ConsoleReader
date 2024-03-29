# ConsoleReader

## Maven

```
<dependency>
    <groupId>pw.navo</groupId>
    <artifactId>consolereader</artifactId>
    <version>1.0.0</version>
    <scope>compile</scope>
</dependency>
```

## How it looks

![howitlooks](http://i.imgur.com/SnKOTDo.gif)

## Usage

```java
ConsoleReader consoleReader = new ConsoleReader("console>");

// The test command is an extra class
consoleReader.registerCommand("test", new TestCommand());

// Lambda style (Java 8 or later)
consoleReader.registerCommand("clear", (String... arguments) -> {
    consoleReader.clearConsole();
});

// This blocks your thread and waits for user input
try {
    consoleReader.listen();
} catch (IOException exception) {
    exception.printStackTrace();
}
```

### License (MIT)

Copyright © 2017 [navopw](https://github.com/navopw)

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
