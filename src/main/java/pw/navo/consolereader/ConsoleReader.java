package pw.navo.consolereader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConsoleReader {

	private String prompt;
	private Map<String, ConsoleCommand> commands;

	/**
	 * At default threadSafe is false
	 * @param prompt
	 */
	public ConsoleReader(String prompt) {
		this(prompt, false);
	}

	/**
	 *
	 * @param prompt
	 * @param threadSafe Decides whether a ConcurrentHashMap or a HashMap will be used
	 */
	public ConsoleReader(String prompt, boolean threadSafe) {
		this.prompt = prompt;
		this.commands = (threadSafe ? new ConcurrentHashMap<>() : new HashMap<>());
	}

	public void listen() throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
			while (true) {
				System.out.print(this.prompt + " ");
				String nextLine = bufferedReader.readLine();

				String[] split = nextLine.split(" ");

				String command = split[0];
				String[] args = Arrays.copyOfRange(split, 1, split.length);

				if (commands.containsKey(command)) {
					this.commands.get(command).onCommand(args);
				} else {
					this.printCommandNotFound();
				}
			}
		}
	}

	private void printCommandNotFound() {
		System.out.println("Command not found!");
	}
	
	public void clearConsole() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void registerCommand(String command, ConsoleCommand consoleCommand) {
		this.commands.put(command, consoleCommand);
	}

	public void unregisterCommand(String command) {
		this.commands.remove(command);
	}

	public interface ConsoleCommand {

		void onCommand(String... arguments);

	}

}
