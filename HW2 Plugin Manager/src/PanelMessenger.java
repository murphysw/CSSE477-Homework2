
public class PanelMessenger {
	private ExecutionPanel executionPanel;
	private ListingPanel listingPanel;
	private StatusPanel statusPanel;
	
	public void setPanels(ExecutionPanel execution, ListingPanel listing, StatusPanel status ){
		this.executionPanel = execution;
		this.listingPanel = listing;
		this.statusPanel = status;
		return;
	}
	
	public void sendMessageToStatus(String message){
		statusPanel.addStringToStatus(message);
	}

	public void switchToPlugin(String file) {
		// TODO Auto-generated method stub
		
	}
}
