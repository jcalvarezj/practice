/*
 * This program implements the Command design pattern the following way:
 * A simple prgram with a Remote Controller that makes a lightbulb turn on and off.
 * The idea is to make it as less coupled as possible, and to be able to have freedom
 * working with the functions in different ways.
 * Based on https://dzone.com/articles/design-patterns-command and https://github.com/kamranahmedse/design-patterns-for-humans
 */


/*
 * This is the main class to execute the program. It corresponds to the Client that uses
 * the Invoker (RemoteController) to use the Receiver's (Lightbulb) actions through Commands.
 * It also creates Commands, Receiver, and Invoker, setting them appropriately
 */
public class CommandPatternLambda {

	public static void main (String args[]) {

		Lightbulb bulb = new Lightbulb();

		RemoteController remote = new RemoteController();
		remote.setCommand(bulb::turnOn);
		remote.execute();

		remote.setCommand(bulb::turnOff);
		remote.execute();
	}
	
}

/*
 * This class represents the Lightbulb, which has the desired functions to execute
 * Hence, this is equivalent to be the Receiver class
 */
class Lightbulb {
	
	public void turnOn() {
		System.out.println("Bulb has been lit");
	}

	public void turnOff() {
		System.out.println("Darkness!!");
	}
	
}

/*
 * This interface generalizes the Command objects that encapsulate and handle function
 * calls to the Lightbulb (the Receiver). The desired handlers in this case are:
 * execute (perform the implementation-specific logic), redo (perform last action again),
 * and undo (to reverse the execution of the last action)
 */
interface Command {
	public void execute();
}

/*
 * This class represents the Remote Controller with Commands that interact with the lightbulb.
 * Hence, it is an Invoker (the client's interface to performing Lightbulb's operations
 * without directly touching the Lightbulb object and functions). 
 */
class RemoteController {
	
	Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}

	public void execute() {
		command.execute();	
	}

}
