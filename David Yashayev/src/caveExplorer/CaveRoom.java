package caveExplorer;

public class CaveRoom {
	
	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	/**
	 * for every door in doors[] appends a String to "directions"
	 * For example:
	 * 	"There is a door to the north"
	 *  "there is a door to the south"
	 *  
	 *  If there are no doors at all directions should say:
	 *  	"There are no doors, you are trapped in here."
	 */
	
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
			for(int i = 0; i < doors.length; i++) {
				if(doors[i] != null) {
					doorFound = true;
					directions += "\n  There is a " + doors[i].getDescription() + " to " + toDirection(i) + ". " + doors[i].getDetails();
				}
				
			}
		if(!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
	}
	
	/**
	 *converts an int to a direction
	 *	toDirection(0) -> "the North"
	 * etc
	 */
	public String getDescription() {
		return description + "\n" + description;
	}
	
	public static String toDirection(int dir) {
		String[] arr = {"the North","the East","the South","the West"};
		return arr[dir];
	}
	
	public void enter() {
		contents = "X";
	}
	
	public void leave() {
		contents = defaultContents;
	}
	
	/**
	 * Gives this room access to anotherRoom(and vice-versa)
	 * and sets a door between them, updating the directions
	 * @param direction
	 * @param anotherRoom
	 * @param door
	 */
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	
	public static int oppositeDirection(int direction) {
		int[] arr = {2,3,0,1};
		return arr[direction];
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}

	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w' , 'a' , 's' or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}
	
	public void goToRoom(int direction) {
		//first, protect against null pointer exception
		//user cannot go thru non-existent doors
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	
	/**
	 * This will be where your group sets up all the 
	 * caves and all the connections
	 */
	
	public static void setUpCaves() {
		//All of this code can be changed
		//1. Decide how big your caves should be
		CaveExplorer.caves = new CaveRoom[5][5];
		//2. Populate with caves and a default description
		//Hint: when starting, use coordinates
		
		for(int row = 0; row < CaveExplorer.caves.length;row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE:
			for(int col = 0; col < CaveExplorer.caves[row].length;col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has coords ("+row+ ", " + col+")"); 
			}
		}
		//3. Replace default rooms with custom rooms
		//- - - We will do this later
		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1],new Door());
	}
	
	private boolean isValid(String input) {
		String validEntries = "wdsa";
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	

	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an 'x' when you are inside this room
		//when you leave it goes back to default contents
		
		//note: by default, arrays will populate with 'null' meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}
}
