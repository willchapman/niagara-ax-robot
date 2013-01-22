// depends: baja; program

import javax.baja.sys.*;
import com.tridium.program.*;
import javax.baja.user.*;

/**
 * Quick robot to find all the users in the station
 * and print the permissions.
 *
 * @author Will Chapman
 */
public class RobotImpl extends Robot {

	public void run() throws Exception {
		printUsers();
	}

	public void printUsers() {
		BUserService serv = (BUserService) Sys.getService(BUserService.TYPE);
		BUser[] users = (BUser[]) serv.getChildren(BUser.class);
		for (int i = 0; i < users.length; i++) {
			log.print(users[i].getName() + " -> ");
			if (!users[i].getEnabled())
				log.println("DISABLED");
			else
				log.println(users[i].getPermissions().encodeToString());
		}
	}
}
