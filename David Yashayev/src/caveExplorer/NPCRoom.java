package caveExplorer;

public class NPCRoom extends CaveRoom{

	private NPC presentNPC;
	
	public NPCRoom(String description) {
		super(description);
		presentNPC = null;
	}

	/**
	 * NPCs can enter a room if no other NPC is there
	 * @return
	 */
	
	public boolean canEnter() {
		return presentNPC == null;
	}
	
	public void enterNPC(NPC m) {
		presentNPC = m;
	}
	
	public void leaveNPC() {
		presentNPC = null;
	}
	
	/**
	 * there's already a method like this, but to make it easier to think about it
	 * we create this to check for an NPC.
	 * If I decide to change the rules for the NPC's this will make it easier of canEnter();
	 * @return
	 */
	
	public boolean containsNPC() {
		return presentNPC != null;
	}
	
	  //The next methods are ALL override methods that replace methods in CaveRoom
	
	public String validKeys() {
		return "wdsae";
	}
	
	public void printAllowedEntry() {
		CaveExplorer.print("You can only enter 'w' , 'a' , 's' or 'd' to move or you can enter 'e' to interact");
	}

	public void performAction(int direction) {
		if(direction == 4) {
			if(containsNPC() && presentNPC.isActive()) {
				presentNPC.interact();
			}else {
				CaveExplorer.print("There is nothing to interact with right now");
			}
			
		} else {
			CaveExplorer.print("That key does nothing.");
		}
	}
	
	public String getContents() {
		if(containsNPC() && presentNPC.isActive()) {
			return "M";
		} else {
			//return what would be returned otherwise
			return super.getContents();
		}
	}
	
	public String getDescription() {
		if(containsNPC() && !presentNPC.isActive()) {
			return super.getDescription() +"\n"+presentNPC.getInactiveDescription();
		}else {
			String npcDesc = "";
			if(presentNPC != null) {
				npcDesc = presentNPC.getActiveDescription();
			}
			return super.getDescription() +"\n"+npcDesc;
		}
	}
}
