import java.io.File;
import java.util.ArrayList;


public class PluginManagerMain {
	
	public static void main(String[] args)
	{
		PluginManagerUI mUI = new PluginManagerUI();
		ArrayList<File> files = new ArrayList<File>();

		while(true){
			ArrayList<File> newFiles = getListOfPlugins();
			if (newFiles != files){
				mUI.updatePluginFolder(newFiles);
				files = newFiles;
			}
		}
	}

	// pulls the list of files from the plugins folder
	private static ArrayList<File> getListOfPlugins() {
		ArrayList<File> plugins = new ArrayList<File>();
		final File directory = new File("src/plugins");
		for (final File file : directory.listFiles()){
			if (file.getName().endsWith(".jar")){
				plugins.add(file);
			}
		}
		
		return plugins;
	}
}
