/*
 * File:    Broken	.java
 * Created: 7 September 2001
 * Author:  Stephen Jarvis
 * Through the usage of loops, the isTargetNorth and isTargetEast functions were fairly intuitive to design. The isTargetNorth function produced simplistic solutions through a line of simplistic code as that of isTargetEast. When designing the heading controller, I chose to set the heading of the Robot to be North so that the absolute and relative directions would be easy to match. As such, within this model, north became equivalent to ahead, east became equivalent to right, west became equivalent to left, and south became equivalent to behind. These setting-based relations allowed the rest of the code to be fairly efficient. The rest of the code used if-else statements, do-while statements, etc to string together the code in a manner that was easy to understand and highly efficient.

Despite meeting the existing specifications of exercise 3 itself, it was recommended to meet the specifications of exercise 1 as well which is why I developed a log that functions through execution of the code as well. Although the code I generated for exercise 3 was highly efficient, it was impossible to make it completely effective. The nature of the specification makes it impossible to create code that consistently reaches the target each time it is run as based on the maze environment, the robot may not exactly always be able to reach the robot by just sensing the direction it is in. I found that a lot of the time, the robot got stuck in loops at corners and deadends where the path towards the target wasn’t completely straight.
 */

import uk.ac.warwick.dcs.maze.logic.IRobot;

public class Ex3 {

  // Method to obtain robot and target's location
  private int isTargetNorth(IRobot robot) {

  // Obtain the vertical y values of the locations of the robot and target
    int a = robot.getLocation().y;
    int b = robot.getTargetLocation().y;

  // Use the values of the locations to determine the relative position (North or South) of the robot from the target
    if (a > b)
    return 1;
    else if (b > a)
    return -1;
    else
    return 0;

  }
  // Method to obtain robot and target's location
  private int isTargetEast(IRobot robot) {

  // Obtain the horizontal x values of the locations of the robot and target
    int c = robot.getLocation().x;
    int d = robot.getTargetLocation().x;

  // Use the values of the locations to determine the relative position (East or West) of the robot from the target
    if (d > c)
    return 1;
    else if (c > d)
    return -1;
    else
    return 0;

  }

  /*// Determine the surrounding of the robot
  private String lookHeading(IRobot robot) {
    robot.setHeading(IRobot.NORTH);
		int heading;
		heading = IRobot.North;

  // Convert to future input
      if (robot.look(heading) == IRobot.WALL)
      return "WALL";
      else if (robot.look(heading) == IRobot.PASSAGE)
      return "PASSAGE";
      else
      return "BEENBEFORE";

  }*/


  public void controlRobot(IRobot robot) {

    int north;
    north = (int) isTargetNorth(robot);
    int east;
    east = (int) isTargetEast(robot);

    // Instruct the robot on where to go based on the target
    if (north == 1)
    robot.face(IRobot.AHEAD);
    else if (north == -1)
    robot.face(IRobot.BEHIND);
    else
      if (east == 1)
      robot.face(IRobot.RIGHT);
      else if (east == -1)
      robot.face(IRobot.LEFT);

    int randno;
    int direction;

    // Perform this function when looking at a wall to avoid collisions
    do {
      // Select a random number relating to a direction
       randno = (int) Math.floor(Math.random()*4);

       // Convert this to a direction
       if ( randno == 0)
            direction = IRobot.LEFT;
       else if (randno == 1)
            direction = IRobot.RIGHT;
       else if (randno == 2)
            direction = IRobot.BEHIND;
       else
            direction = IRobot.AHEAD;
    } while (robot.look(direction) == IRobot.WALL);

    robot.face(direction);  /* Face the direction */

    // Perform this function when looking at a wall to avoid collisions
    /*do {

      // Select a random number relating to a direction
       randno = (int) Math.floor(Math.random()*4);

       // Convert this to a direction
       if ( randno == 0)
            direction = IRobot.LEFT;
       else if (randno == 1)
            direction = IRobot.RIGHT;
       else if (randno == 2)
            direction = IRobot.BEHIND;
       else
            direction = IRobot.AHEAD;
    } while (lookHeading(robot) = IRobot.WALL);

    robot.face(direction);*/  /* Face the direction */

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
