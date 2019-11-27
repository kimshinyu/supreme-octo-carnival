package RobocodeRobots.AronRobots;
import static robocode.util.Utils.normalRelativeAngleDegrees;

//import java.awt.Color;
import robocode.HitByBulletEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * BasicRobot - a robot by (Aron)
 */
public class BasicRobot extends Robot
{
	/**
	 * run: BasicRobot's default behavior
	 */
	boolean peek;
	int count = 0; // Keeps track of how long we've
	// been searching for our target
	double angleToEnemy; // How much to turn our gun when searching
	String trackName; // Name of the robot we're currently tracking
	
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Prepare gun
		trackName = null; // Initialize to not tracking anyone
		setAdjustGunForRobotTurn(true); // Keep the gun still when we turn
		angleToEnemy = 10; // Initialize gunTurn to 10

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			while(trackName == null){
				track();
			}
			if(getOthers() == 1){
				slowCrawl();
			}else{
				evasiveManouvers();
			}
			track();
				
			
		}
	}

	private void slowCrawl(){
		peek = true;
		double moveAmount = Math.max(getBattleFieldWidth(), getBattleFieldHeight()); // How much to move
		// Move up the wall
		ahead(moveAmount);
		// Don't look now
		peek = false;
		// Turn to the next wall
		turnRight(30);
	}
	private void evasiveManouvers(){
		turnLeft(30);
		ahead(50);
		turnRight(20);
		back(40);
		turnLeft(40);
	}
	
	private void track(){
		
		turnGunRight(angleToEnemy);
			// Keep track of how long we've been looking
			count++;
			// If we've haven't seen our target for 2 turns, look left
			if (count > 2) {
				angleToEnemy = -10;
			}
			// If we still haven't seen our target for 5 turns, look right
			if (count > 5) {
				angleToEnemy = 10;
			}
			// If we *still* haven't seen our target after 10 turns, find another target
			if (count > 11) {
				trackName = null;
			}
	}
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
	// Calculate exact location of the robot
		this.trackName = e.getName();
		double absoluteBearing = getHeading() + e.getBearing();
		angleToEnemy = normalRelativeAngleDegrees(absoluteBearing - getGunHeading());
		boolean isMoving = true;
		double firepower = 3;

		// If it's close enough, fire!
		if (Math.abs(angleToEnemy) <= 1.6) {
			turnGunRight(angleToEnemy);
			// We check gun heat here, because calling fire()
			// uses a turn, which could cause us to lose track
			// of the other robot.
			if (getGunHeat() == 0) {
				if(e.getDistance() < 200) firepower = 10;
				if(!isMoving) firepower = 20;
				fire(Math.min(firepower - Math.abs(angleToEnemy), getEnergy() - firepower/10));
				firepower = 3;
			}
		} // otherwise just set the gun to turn.
		// Note:  This will have no effect until we call scan()
		else {
			turnGunLeft(3-angleToEnemy);
		}
		// Generates another scan event if we see a robot.
		// We only need to call this if the gun (and therefore radar)
		// are not turning.  Otherwise, scan is called automatically.
		if (angleToEnemy == 0) {
			scan();
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Only print if he's not already our target.
		if (trackName != null && !trackName.equals(e.getName())) {
			out.println("Tracking " + e.getName() + " due to collision");
		}
		// Set the target
		trackName = e.getName();
		// Back up a bit.
		// Note:  We won't get scan events while we're doing this!
		// An AdvancedRobot might use setBack(); execute();
		angleToEnemy = normalRelativeAngleDegrees(e.getBearing() + (getHeading() - getRadarHeading()));
		if (Math.abs(angleToEnemy) <= 3) {
			turnGunRight(angleToEnemy);
		}else{
			turnGunLeft(3-angleToEnemy);
		}
		fire(3);
		back(50);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
			turnRight(80);
	}	
}
