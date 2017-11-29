package pokemon;

public class Pokemon {

	private int level;
	private int hp;
	private String name;
	private boolean poisoned;
	
	public Pokemon(String name, int level) {
		this.name = name;
		this.level = level;
		hp = 100;
		poisoned = false;
	}
	
	public void iChooseYou(){
		System.out.println(this.name + " " + this.name);
	}
	
	public int getHP() {
		return this.hp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHP(int newHP) {
		this.hp = newHP;
	}
	
	public void setPoisoned(boolean b) {
		this.poisoned = b;
	}
	
	public void lapse() {
		if(poisoned) {
			hp = hp - 15;
		}
	}
	
	public static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName()+", HP = "+p1.getHP());
		System.out.println(p2.getName()+", HP = "+p2.getHP());
	}
	
	public void levelUp(Effect e) {
		this.level++;
		e.effect();
	}
	
	public void effect() {
		
	}
	
	public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHP();
		 target.setHP(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
			 target.setPoisoned(true);
		 	}
		 });
		 	squirtle.lapse();
		 	bulbasaur.lapse();
		 	printScore(squirtle, bulbasaur);
		 	System.out.println("Squirtle is attacking again");
		 	squirtle.attack(bulbasaur,new Attack() {
				
				public void attack(Pokemon target) {
					int oldHP = target.getHP();
					target.setHP(oldHP - 1);
				}
			});
		 	printScore(squirtle, bulbasaur);
		 	squirtle.levelUp(new Effect() {
				
				public void effect(Pokemon pokemon) {
					System.out.println("Squirtle leveled up!");
				}
			});
		 }
	
	 public void attack(Pokemon target, Attack attack){
		if(Math.random() < .9){
			attack.attack(target);
			System.out.println("The attack hit");
		 	}else{
		 		System.out.println("The attack missed");
		 	}
	}
}
