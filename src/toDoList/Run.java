package toDoList;

import java.awt.*;

import ui.DarkColor;
import ui.Layout;
import ui.ListElementPanel;

import javax.swing.*;

public class Run {

	
	public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub


		UIManager.put("nimbusBase", DarkColor.BACKGROUND);
		UIManager.put("nimbusBlueGrey", DarkColor.ACTIVE_BUTTON);
		UIManager.put("control", DarkColor.BACKGROUND);
		UIManager.put("nimbusLightBackground",DarkColor.TEXT_INPUT);
		UIManager.put("nimbusFocus", DarkColor.ACTIVE_BUTTON);
		UIManager.put("text", DarkColor.TEXT);

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}

		TaskHandler handler = new TaskHandler();
		Layout layout = new Layout(handler);
	}
	

}
