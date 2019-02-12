package pw.navo.consolereader;

import java.io.IOException;

public class ConsoleReaderTest {

    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader("console>");

        //the test command is an extra class
        consoleReader.registerCommand("test", new TestCommand());

        //lambda style (later or java 8)
        consoleReader.registerCommand("clear", (String... arguments) -> {
            consoleReader.clearConsole();
        });

        //this blocks your thread and waits for user input
        try {
            consoleReader.listen();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static class TestCommand implements ConsoleReader.ConsoleCommand {

        @Override
        public void onCommand(String... arguments) {
            System.out.println("You executed the command \"test\" with following arguments: " + String.join(", ", arguments));
        }
    }

}
