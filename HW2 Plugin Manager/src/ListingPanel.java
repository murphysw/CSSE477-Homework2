import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ListingPanel extends JPanel implements ListSelectionListener {
	DefaultListModel<File> listModel;
	public ListingPanel() {
		super();
		setBackground(Color.RED);
		this.setVisible(true);
		listModel = new DefaultListModel<File>();
		JList<File> list = new JList<File>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(5);
		JScrollPane listScrollPane = new JScrollPane(list);
		this.add(list);
		this.add(listScrollPane);
	}

	public void updateListOfPlugins(ArrayList<File> files) {
		// TODO display the list of files
		listModel = new DefaultListModel<File>();
		for(File file : files){
			listModel.addElement(file);
			System.out.println(file.toString());
		}
		this.update(this.getGraphics());
		return;
		
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
