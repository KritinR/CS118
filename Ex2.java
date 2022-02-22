/*
* File: DumboController.java
* Created: 17 September 2002, 00:34
* Author: Stephen Jarvis
* 
*/

import uk.ac.warwick.dcs.maze.logic.IRobot;

public class DumboController
{

	public void controlRobot(IRobot robot) {

		int randno;
		int direction;

		// Set direction to ahead and insure that 1 in every 8 random numbers results in a direction switch if there is no wall
		direction = IRobot.AHEAD;

		// Pick random number and choose a direction based on that
		randno = (int) Math.floor(Math.random()*8);
		if (randno == 1 && robot.look(direction) != IRobot.WALL)
				direction = IRobot.AHEAD;
		else
			do {
			// Select a random number relating to a direction
			randno = (int) Math.floor(Math.random()*6 + 1);

			// Convert this to a direction
			if (randno == 0)
			direction = IRobot.RIGHT;
			else if (randno == 2)
			direction = IRobot.BEHIND;
			else if (randno == 3)
			direction = IRobot.LEFT;
			else if (randno == 4)
			direction = IRobot.RIGHT;
			else if (randno == 5)
			direction = IRobot.BEHIND;
			else if (randno == 6)
			direction = IRobot.LEFT;
			else
			direction = IRobot.LEFT;
		} while (robot.look(direction) == IRobot.WALL);

	// Face robot in direction chosen
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
