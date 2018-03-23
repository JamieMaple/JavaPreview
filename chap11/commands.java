package entry;

import java.util.LinkedList;
import java.util.Queue;

class Command {
	public String name;
	public Command(String name) {
		this.name = name;
	}
	public void operation() {
		System.out.println("Command: " + name);
	}
}

class Main {
	public static Command enqueue(Queue<Command> queue, Command command) {
		queue.offer(command);
		return command;
	}
	public static void operateCommand(Queue<Command> queue) {
		Command command = queue.poll();
		if (command != null) {
			command.operation();
		}
	}
	public static void main(String[] args) {
		Queue<Command> commands = new LinkedList<Command>();
		enqueue(commands, new Command("Hello"));
		enqueue(commands, new Command("World"));
		
		operateCommand(commands);
		operateCommand(commands);
		operateCommand(commands);
	}
}
