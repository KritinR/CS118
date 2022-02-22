/**
* File: DumboController.java
* Created: 17 September 2002, 00:34
* Author: Stephen Jarvis
* Excercise 1 Preamble
* The java file has been meticulously crafted to provide solutions to equalizing the randomizer which I chose to do by changing “math.round” to “math.floor”  and “3” to “4” in “math.round(math.random) *3” as this ensured a more equal response due to the ability of the floor command to distribute the numbers evenly. The reason why “math.floor” is more successful in producing a better distribution of numbers is due to the fact that “math.round” rounds to the nearest number whereas floor consistently rounds down. Additionally, in order to fulfill the initial requirements of the specification, I created a function that determined the direction to be ahead at all times unless a wall was present. I performed the aforementioned tasks through a diverse range of information learned throughout the course including a for-loop, a while-loop, number generation, incrementation, etc--this was done to reach my stylistic goal of clarity and concision.

I recognize that there are alternative commands that may look better, but as per my stylization, I like to put importance on efficiency and readability which justifies my output. Lastly, I incorporated the 1-in-8 chance through a random number generator between 0 and 8 where if 1 was chosen, the output would change no matter if there was a wall ahead or not. Expanding on my stylization technique that prioritizes the working and understandable nature of my code, I truly believe there are few ways to improve my code in a better manner using what we have learned in the course so far as well as through further research in the optional readings that have been provided. Regardless, I do understand that as a computer scientist it is important to recognize that code can always be improved and I would say that the random integer generator could be more effective if another method was established.
*/

import uk.ac.warwick.dcs.maze.logic.IRobot;

public class Ex1 {

	public void controlRobot(IRobot robot) {

		int randno;
		int direction;

		// Perform this function when looking at a wall to avoid collisions
		do {
		// Select a random number relating to a direction
		randno = (int) Math.round(Math.random()*3);

		// Convert this to a direction
		if (randno == 0)
		direction = IRobot.LEFT;
		else if (randno == 1)
		direction = IRobot.RIGHT;
		else if (randno == 2)
		direction = IRobot.BEHIND;
		else
		direction = IRobot.AHEAD;
	} while (robot.look(direction) == IRobot.WALL);

	robot.face(direction); /* Face the robot in this direction */

	int heading;

	// Obtain the direction at which the robot is facing
	heading = (int) robot.getHeading();

	// Use this direction to print the first portion of the log
	if (heading == IRobot.WEST)
	System.out.print("I'm going left");
	else if (heading == IRobot.EAST)
	System.out.print("I'm going right");
	else if (heading == IRobot.SOUTH)
	System.out.print("I'm going backwards");
	else
	System.out.print("I'm going forward");

	int walls = 0;

	// Count the number of walls around the robot
	if (robot.look(IRobot.LEFT) == IRobot.WALL)
	walls = walls + 1;
	else
	walls = walls + 0;
	if (robot.look(IRobot.RIGHT) == IRobot.WALL)
	walls = walls + 1;
	else
	walls = walls + 0;
	if (robot.look(IRobot.BEHIND) == IRobot.WALL)
	walls = walls + 1;
	else
	walls = walls + 0;
	if (robot.look(IRobot.AHEAD) == IRobot.WALL)
	walls = walls + 1;
	else
	walls = walls + 0;

	// Use the number of walls to determine where the robot is on the map and complete the log
	if (walls < 1)
	System.out.println(" at a crossroads");
	else if (walls < 2)
	System.out.println(" at a junction");
	else if (walls < 3)
	System.out.println(" down a corridor");
	else
	System.out.println(" at a dead end");
	}
}
