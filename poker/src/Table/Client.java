package Table;

import java.io.IOException;
import java.net.Socket;
import Player.Human;

public class Client {
	static Human human;
    static Socket socket;

    public static void main(String[] args) {
    	
    	try {
    		    socket = new Socket("localhost", 5218);
    		    human = new Human(socket);
    		    human.start();
    		   
    	}catch(IOException e)
    	{
    	}
    	
    }
    
}
