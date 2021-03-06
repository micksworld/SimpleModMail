package world.micks.listener;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import world.micks.Const;
import world.micks.utils.Utils;

public class IveBeenTagged extends ListenerAdapter {

	@Override public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		User author = event.getAuthor();
		MessageChannel channel = event.getChannel();
		Message message = event.getMessage();
		String content = message.getContentRaw();
		
		if(content.contentEquals(Utils.pingUser(817485073883725854l))) {
			
			MessageEmbed embed = new EmbedBuilder()
					
					.setDescription("<a:heart:807836412984033331> Hey there, " + author.getAsMention() + ",\nI can only be used via DM! Please DM me and type ``m?help`` to get started!")
					.setFooter("Requested by " + author.getAsTag())
					.setColor(Const.color)
					
					.build();
			
			channel.sendMessage(embed).queue();
			
		}
		
	}
	
}
