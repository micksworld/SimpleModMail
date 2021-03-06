package world.micks;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import world.micks.listener.DirectMessageEvents;
import world.micks.listener.IveBeenTagged;

public class ModMail {

	private static JDA api;
	public static JDA getApi() { return api; }
	
	public static void main(String[] args) throws LoginException {
		
		api = JDABuilder.createDefault(Key.get())
				
				.setActivity(Activity.watching("Mick's World 💎"))
				.enableIntents(GatewayIntent.DIRECT_MESSAGES, GatewayIntent.GUILD_EMOJIS)
				.addEventListeners(new DirectMessageEvents(), new IveBeenTagged())
				
				.build();
		
	}
	
}
