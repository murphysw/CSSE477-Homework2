import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;


public class ListingPanel extends JPanel implements ListSelectionListener {
	DefaultListModel<String> listModel;
	public ListingPanel() {
		super();
		setBackground(Color.RED);
		this.setVisible(true);
	}

	public void updateListOfPlugins(ArrayList<String> files) {
		// TODO display the list of files
		this.removeAll();
		listModel = new DefaultListModel<String>();
		for(String file : files){
			listModel.addElement(file);
			System.out.println(file.toString());
			JLabel label = new JLabel(file);
			this.add(label);
		}
		
		this.paintAll(this.getGraphics());
		return;
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
