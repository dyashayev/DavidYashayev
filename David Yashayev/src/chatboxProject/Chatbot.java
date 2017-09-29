package chatboxProject;

public class Chatbot {

	private String userName;
	private ChatbotDavid david;
	private boolean chatting;
	
	public Chatbot() {
		david = new ChatbotDavid();
		userName = "unknown user";
		chatting = true;
	}
	
	public void startTalking() {
		ChatbotMain.print("Welcome to our chatbot! What is your name?");
		userName = ChatbotMain.getInput();
		chatting = true;
		while(chatting) {
			ChatbotMain.print("what do you want to talk about?");;
			String response = ChatbotMain.getInput();
				if(david.isTriggered(response)) {
					chatting = false;
					david.startChatting(response);
				} else {
					ChatbotMain.print("I'm sorry. I don't understand.");
				}
		}
	}

}
