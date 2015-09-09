package me.Flibio.JobsLite.Utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;

import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.Texts;
import org.spongepowered.api.text.action.TextActions;
import org.spongepowered.api.text.format.TextColor;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.util.Consumer;
import org.spongepowered.api.util.command.CommandSource;


public class TextUtils {
	
	public static Text yesOption(Consumer<CommandSource> onClick) {
		Text yes = Texts.builder("[").color(TextColors.DARK_GRAY).build();
		yes = yes.builder().append(Texts.builder("YES").color(TextColors.GREEN).build()).build();
		yes = yes.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		
		yes = yes.builder().onHover(TextActions.showText(Texts.builder("YES!").color(TextColors.GREEN).build())).build();
		
		yes = yes.builder().onClick(TextActions.executeCallback(onClick)).build();
		
		return yes;
	}
	
	public static Text noOption(Consumer<CommandSource> onClick) {
		Text no = Texts.builder("[").color(TextColors.DARK_GRAY).build();
		no = no.builder().append(Texts.builder("NO").color(TextColors.RED).build()).build();
		no = no.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		
		no = no.builder().onHover(TextActions.showText(Texts.builder("NO!").color(TextColors.RED).build())).build();
		
		no = no.builder().onClick(TextActions.executeCallback(onClick)).build();
		
		return no;
	}
	
	public static Text option(Consumer<CommandSource> onClick, TextColor color, String option) {
		Text text = Texts.builder("[").color(TextColors.DARK_GRAY).build();
		text = text.builder().append(Texts.builder(option).color(color).build()).build();
		text = text.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		
		text = text.builder().onHover(TextActions.showText(Texts.builder(option).color(color).build())).build();
		
		text = text.builder().onClick(TextActions.executeCallback(onClick)).build();
		
		return text;
	}
	
	public static Text cancelText() {
		Text cancel = Texts.builder().build();
		cancel = cancel.builder().append(Texts.builder("If at any point you would like to cancel job creation, please type ").color(TextColors.YELLOW).build()).build();
		cancel = cancel.builder().append(Texts.builder("[").color(TextColors.DARK_GRAY).build()).build();
		cancel = cancel.builder().append(Texts.builder("CANCEL").color(TextColors.RED).build()).build();
		cancel = cancel.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		
		return cancel;
	}
	
	public static Text cancelled() {
		Text cancel = Texts.builder("Cancelled ").color(TextColors.RED).build();
		cancel = cancel.builder().append(Texts.builder("job creation!").color(TextColors.YELLOW).build()).build();
		
		return cancel;
	}
	
	public static Text nameQuestion(String name, boolean spaces, boolean nothing) {
		Text question = Texts.builder().build();
		question = question.builder().append(Texts.builder("What would you like the ").color(TextColors.YELLOW).build()).build();
		question = question.builder().append(Texts.builder(name).color(TextColors.GREEN).build()).build();
		question = question.builder().append(Texts.builder(" of the job to be?").color(TextColors.YELLOW).build()).build();
		if(!nothing) {
			if(spaces) {
				question = question.builder().append(Texts.builder(" (Spaces Allowed)").color(TextColors.GREEN).build()).build();
			} else {
				question = question.builder().append(Texts.builder(" (No Spaces)").color(TextColors.GREEN).build()).build();
			}
		}
		return question;
	}
	
	public static Text registered(String what, String value) {
		Text register = Texts.builder("Registered ").color(TextColors.YELLOW).build();
		register = register.builder().append(Texts.builder(what+": ").color(TextColors.YELLOW).build()).build();
		register = register.builder().append(Texts.builder(value).color(TextColors.GREEN).build()).build();
		
		return register;
	}
	
	public static Text chatMessage(String name, String jobName, TextColor jobColor, String message) {
		Text text = Texts.builder("[").color(TextColors.DARK_GRAY).build();
		text = text.builder().append(Texts.builder(jobName).color(jobColor).build()).build();
		text = text.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		text = text.builder().append(Texts.builder(" "+name+" ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder(message).color(TextColors.WHITE).build()).build();
		
		return text;
	}
	public static Text chatMessage(String name, String jobName, int level, TextColor jobColor, String message) {
		Text text = Texts.builder("[").color(TextColors.DARK_GRAY).build();
		text = text.builder().append(Texts.builder(jobName).color(jobColor).build()).build();
		text = text.builder().append(Texts.builder("]").color(TextColors.DARK_GRAY).build()).build();
		text = text.builder().append(Texts.builder(" {").color(TextColors.DARK_GRAY).build()).build();
		text = text.builder().append(Texts.builder(level+"").color(jobColor).build()).build();
		text = text.builder().append(Texts.builder("}").color(TextColors.DARK_GRAY).build()).build();
		text = text.builder().append(Texts.builder(" "+name+" ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder(message).color(TextColors.WHITE).build()).build();
		
		return text;
	}
	
	public static Text levelUp(String name, int newLevel, String job) {
		Text text = Texts.builder("Congratulations ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(name).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(", you are now a ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder("level "+newLevel).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" "+job+"!").color(TextColors.GOLD).build()).build();
		
		return text;
	}
	
	public static Text toGo(int toGo, int nextLevel, String job) {
		Text text = Texts.builder("You now need ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(NumberFormat.getNumberInstance(Locale.US).format(toGo)+" exp").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" to become a ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder("level "+nextLevel).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" "+job+"!").color(TextColors.GOLD).build()).build();
		
		return text;
	}
	
	public static Text maxLevel(String job) {
		Text text = Texts.builder("You are now a ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder("max-level").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" "+job+"!").color(TextColors.GOLD).build()).build();
		
		return text;
	}
	
	public static Text reward(String doing, String what, String reward, String suffix) {
		Text text = Texts.builder("Reward for ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(doing).color(TextColors.GOLD).build()).build();
		text = text.builder().append(Texts.builder(" "+what+": ").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(reward).color(TextColors.DARK_GREEN).build()).build();
		if(!suffix.isEmpty()) {
			text = text.builder().append(Texts.builder(" "+suffix).color(TextColors.DARK_GREEN).build()).build();
		}
		
		return text;
	}
	
	public static Text howMuch(String what) {
		Text text = Texts.builder("How much ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(what).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" will this give?").color(TextColors.YELLOW).build()).build();
		
		return text;
	}
	
	public static Text another(String what) {
		Text text = Texts.builder("Do you want to add another ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(what+"?").color(TextColors.GREEN).build()).build();
		
		return text;
	}
	
	public static Text addQuestion(String earn1, String earn2, String fromWhat) {
		Text text = Texts.builder("Do you want the player to earn ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(earn1).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" and ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder(earn2).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" from ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder(fromWhat+"?").color(TextColors.GREEN).build()).build();
		
		return text;
	}
	
	public static Text clickInstruction(String action) {
		Text text = Texts.builder("Please right-click on the ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder("block").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" you want the player to earn ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder("currency").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" and ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder("experience").color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" from when they ").color(TextColors.YELLOW).build()).build();
		text = text.builder().append(Texts.builder(action).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" it.").color(TextColors.YELLOW).build()).build();
		return text;
	}
	
	public static Text instruction(String action) {
		Text text = Texts.builder("Please ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(action+":").color(TextColors.GREEN).build()).build();

		return text;
	}
	
	public static Text saved(String what) {
		Text text = Texts.builder("Successfully saved ").color(TextColors.YELLOW).build();
		text = text.builder().append(Texts.builder(what).color(TextColors.GREEN).build()).build();
		text = text.builder().append(Texts.builder(" as a job!").color(TextColors.YELLOW).build()).build();

		return text;
	}
	
	public static Text success(String what, TextColor color) {
		Text text = Texts.builder(what).color(color).build();

		return text;
	}
	
	public static Text error(String error) {
		return Texts.builder(error).color(TextColors.RED).build();
	}
	
	public static Text line() {
		Text text = Texts.builder("").build();
		
		return text;
	}
	
	public Text change(String change) {
		Text text = Texts.builder(" + ").color(TextColors.YELLOW).build();
		
		text = text.builder().append(Texts.builder(change).color(TextColors.GREEN).build()).build();
		
		return text;
	}
	
	public Text updateAvailable(String version, String url) {
		Text text = Texts.builder("JobsLite").color(TextColors.GREEN).build();
		text = text.builder().append(Texts.builder(" v"+version).color(TextColors.LIGHT_PURPLE).build()).build();
		text = text.builder().append(Texts.builder(" is now available to download! ").color(TextColors.YELLOW).build()).build();
		try {
			text = text.builder().append(Texts.builder(url).color(TextColors.GRAY).onClick(TextActions.openUrl(new URL(url))).build()).build();
		} catch (MalformedURLException e) {}
		
		return text;
	}
	
}