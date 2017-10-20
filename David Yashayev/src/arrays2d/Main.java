package arrays2d;

public class Main {
	
	public static void main(String[] args) {
		
	}

	// THIS idea is another major topic in AP CSA
	//It is the idea of avoiding an ArrayIndexOutofBoundsException
	//you will see it on quizzes, tests, and project rubrics
	
	public static void changeNeighbors(int[] arr, int psn) {
		boolean done = false;
		while(!done) {
			try{
				arr[psn] = arr[psn] + 1;
				arr[psn - 1] = arr[psn - 1] - 1;
				arr[psn + 1] = arr[psn + 1] - 1;
				done = true;
			}
			catch(ArrayIndexOutOfBoundsException){
				if(psn == 0) {
					arr[psn] = arr[psn] + 1;
				}
			}
		}
	}
}
