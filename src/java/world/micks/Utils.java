package world.micks.utils;

import java.util.List;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;

public class Utils {

	public static String pingUser(String ID) { return "<@!" + ID + ">"; }
	public static String pingUser(long ID) { return "<@!" + ID + ">"; }
	
}
