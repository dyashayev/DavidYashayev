package arrays;

public class Person {
	
	public static final String[] FIRST_START = {"Chr", "M", "L", "Gr", "Ph", "B", "Th"};
	public static final String[] FIRST_MIDDLE = {"isti", "icha", "ere", "eta", "ala", "ina", "ara"};
	public static final String[] FIRST_END = {"", "na", "n", "r", "tain", "s", "rs", "mp", "les"};

	public static final String[] LAST_START = {"Tr", "Br", "L", "Gr", "Sh", "B", "Th"};
	public static final String[] LAST_MIDDLE = {"om", "o", "an", "ola", "et", "e", "is"};
	public static final String[] LAST_END = {"", "son", "ers", "rian", "ston", "ck", "sk"};

	private String firstName;
	private String lastName;
	private Borough home;
	private String nickname;
	
	public Person(String first, String last, Borough home) {
		this.firstName = first;
		this.lastName = last;
		this.home = home;
		this.nickname = createNickname(firstName);
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
		nickname = createNickname(firstName);
	}



	public String toString() {
		return "My name is " + firstName + " " + lastName + ", call me " + nickname + " and I live in " + home + ".";
	}
	
	//JAVA IS PASS-BY-VALUE
	//this means: the parameters of a method are just values,
	//not references. if you change those values, the original
	//object is the same. In this case, 'name' will not be changed.
	//In fact nothing can change this.firstName via name (local variable)
	public static String createNickname(String name) {
		
		int vowelCount = 0;
			for(int i = 0; i < name.length(); i++) {
				String check = name.substring(i,i+1);
					if(vowelCount < 0 && isVowel(check)) {
						vowelCount++;
					}else if(isVowel(check))
						return name.substring(0,i);
			}
			return name;
		}
	
	public static boolean isVowel(String a) {
		if(a.equals("a") || a.equals("e") || a.equals("i") || a.equals("o") || a.equals("u"))
			return true;
		return false;
	}
}
