package auth;

import java.io.File;
import java.util.Scanner;


public class Auth 
{
	public boolean isValidUser(String userName)
	{
		boolean isLoginSuccess = false;
		Scanner fileScanner = null;
		
		try {
			File users = new File("UserAccounts.txt");
			fileScanner = new Scanner(users);
			
			while (fileScanner.hasNextLine()) 
			{
				String[] attributes = fileScanner.nextLine().split(",");
				
				String fUserName = attributes[1].trim();
				
				if(fUserName.equals(userName)) 
				{
					isLoginSuccess = true;
					User user = new User(
							Integer.parseInt(attributes[0].trim()),
							attributes[1].trim(), 
							attributes[2].trim(), 
							Integer.parseInt(attributes[3].trim()),
							attributes[4].trim(), 
							attributes[5].trim(),
							attributes[6].trim()							
							);
					
					//store logged in user for later use
					UserSession.getInstace(user);
							
					//this.dispose();
                    //MainMenu mm = new MainMenu();
                    //mm.setLocationRelativeTo(null);
                    //mm.setVisible(true);
					fileScanner.close();
					return isLoginSuccess;					
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally 
		{
			fileScanner.close();
		}
		return isLoginSuccess;
	}
}