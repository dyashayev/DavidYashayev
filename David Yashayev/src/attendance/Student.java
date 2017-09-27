package attendance;

public class Student implements Attendee {
	
	boolean present = false;
	String firstName;
	String lastName;
		public Student(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		public boolean isPresent() {
			return present;
		}
		
		public void setPresent(boolean present) {
			this.present = present;
		}
		
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public boolean mathces(String first, String last) {
			return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
		}
		public boolean matches(String last) {
			return last.toLowerCase().equals(lastName.toLowerCase());
		}
		public String getReportString() {
			String report = lastName;
			report = restrictStringToLength(report,20);
			report += firstName;
			report = restrictStringToLength(report,40);
			if(present)
				report+="Present\n";
			else
				report += "Absent\n";
		return report;
		}

		public String restrictStringToLength(String s1, int x) {
			if(s1.length() > x) {
				s1 = s1.substring(0,x-3) + "...";
			}
			else {
				while(s1.length() < x)
					s1 += " ";
			}
			return s1;
		}
}
