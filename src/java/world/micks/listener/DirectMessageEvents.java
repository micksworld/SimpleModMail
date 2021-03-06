package world.micks.listener;

import java.awt.Color;
import java.time.Instant;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.PrivateChannel;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import world.micks.Const;
import world.micks.ModMail;

public class DirectMessageEvents extends ListenerAdapter {

	@Override public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
		
		PrivateChannel channel = event.getChannel();
		TextChannel mod = ModMail.getApi().getTextChannelById(Const.CHANNELID);
		Message message = event.getMessage();
		String content = message.getContentRaw();
		String[] args = content.split(" ");
		User user = event.getAuthor();
		
		if(content.startsWith("m?help")) {
			
			MessageEmbed embed = new EmbedBuilder()
					
					.setDescription("<a:yellow:812546824527282246> **ModMail Help**\nm?new [message] - Send a message to our staff\nm?feedback [message] - Leave us a feedback !!")
					.setFooter("Requested by "  + event.getAuthor().getAsTag())
					.setColor(Const.color)
					
					.build();
			
			channel.sendMessage(embed).queue();
			
		} else if(content.startsWith("m?new")) {
			
			if(args.length == 1) {
				
				MessageEmbed embed = new EmbedBuilder()
						
						.setDescription("<a:pushpin:807836414670667867> **New Message**\nYou're missing your message !")
						.setFooter("Requested by " + event.getAuthor().getAsTag())
						.setColor(Const.color)
						
						.build();
				
				channel.sendMessage(embed).queue();
				
			} else {
				
				MessageEmbed embed = new EmbedBuilder()
						
						.setDescription("<a:dancingpepe:807836413097148417> **New Message**\nYou're message has been sent !\n\n\" " + content.replace("m?new", "") + "\"")
						.setFooter("Requested by " + event.getAuthor().getAsTag())
						.setColor(new Color(37, 153, 54))
						
						.build();
				
				channel.sendMessage(embed).queue();
				
				MessageEmbed recieved = new EmbedBuilder()
						
						.setAuthor(user.getAsTag(), null, user.getAvatarUrl() != null ? user.getAvatarUrl() : user.getDefaultAvatarUrl())
						.setDescription(content.replace(args[0], ""))
						.setTimestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
						.setFooter("New message by " + user.getAsTag())
						.setColor(Const.color)
						
						.build();
				
				mod.sendMessage(recieved).queue();
				
			}
			
		} else if(content.startsWith("m?feedback") || content.startsWith("m?fb")) {
			
			if(args.length == 1) {
				
				MessageEmbed embed = new EmbedBuilder()
				
						.setDescription("<a:white:812546824442478613> **ModMail Feedback**\nYou're missing a message!")
						.setColor(Const.color)
						.setFooter("Requested by " + user.getAsTag())
						
						.build();
				
				channel.sendMessage(embed).queue();
				
			} else {
				
				MessageEmbed embed = new EmbedBuilder()
						
						.setDescription("<a:dancingpepe:807836413097148417> **ModMail Feedback**\nYou're feedback has been sent !\n\n\" " + content.replace("m?new", "") + "\"")
						.setFooter("Requested by " + event.getAuthor().getAsTag())
						.setColor(new Color(37, 153, 54))
						
						.build();
				
				channel.sendMessage(embed).queue();
				
				MessageEmbed recieved = new EmbedBuilder()
						
						.setAuthor(user.getAsTag(), null, user.getAvatarUrl() != null ? user.getAvatarUrl() : user.getDefaultAvatarUrl())
						.setDescription(content.replace(args[0], ""))
						.setTimestamp(Instant.ofEpochMilli(System.currentTimeMillis()))
						.setFooter("New feedback by " + user.getAsTag())
						.setColor(Const.color)
						
						.build();
				
				mod.sendMessage(recieved).queue();
				
			}
			
		}
		
	}
	
}
