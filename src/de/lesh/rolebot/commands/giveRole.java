package de.lesh.rolebot.commands;

import de.lesh.rolebot.user.bannedList;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class giveRole extends ListenerAdapter{

	public void onMessageReceived(MessageReceivedEvent e){
		Message msg = e.getMessage();
		User user = e.getAuthor();
		User getUser = e.getGuild();
		
		if(!msg.getRawContent().startsWith(".r") || bannedList.black.contains(e.getAuthor().getIdLong()) || e.getAuthor().isBot()) {
			return;
		}
		
		String role = e.getMessage().getRawContent().split("\\s+", 2)[1];
		
		switch(role){
			case "beginner" : e.getGuild().getRoles(); //.getRoleById(316125948544155649L).;
			case "medium" : 
			case "profi" : 
				
			default : e.getChannel().sendMessage("Die angegebene Gruppe ist nicht vorhanden. \n Bitte w�hle zwischen beginner , medium oder profi").queue();
		}
	}
}

