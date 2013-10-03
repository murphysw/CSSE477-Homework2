import java.awt.Color;

import javax.swing.JPanel;


public class ExecutionPanel extends JPanel {
	private PanelMessenger messenger;
	public ExecutionPanel() {
		super();

		setBackground(Color.BLUE);
		setVisible(true);
	}
	public void setMessenger(PanelMessenger messenger) {
		this.messenger = messenger;
		
	}
}
