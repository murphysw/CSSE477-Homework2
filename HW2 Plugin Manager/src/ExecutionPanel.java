import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.Attributes;

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
	
	public boolean updateExecutedPlugin(String jarName) throws IOException{
	    try {
	        File file = new File("plugins", jarName);
	        
	        URI uri = file.toURI();
//	        System.out.println(file.toURI().getPath());
	        URL url = new URL("jar:" + uri + "!/");
	        URL[] urls = {url};
	        URLClassLoader classLoader = new URLClassLoader(urls);
	        JarURLConnection uc = (JarURLConnection)url.openConnection();
	        String main = uc.getMainAttributes().getValue(Attributes.Name.MAIN_CLASS);
	        	        
			Class<?> aClass = classLoader.loadClass(main);
			String[] thing = {};
			try {
				Method m = aClass.getMethod("main", thing.getClass());
				m.setAccessible(true);
				m.invoke(null, new Object[]{ thing });
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        return true;
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
