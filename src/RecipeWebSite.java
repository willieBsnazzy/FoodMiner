import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class RecipeWebSite extends JFrame {

	private JPanel contentPane;
	private String recipeURL;
	
	public RecipeWebSite(String recipeURL) {
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		springLayout.putConstraint(SpringLayout.NORTH, editorPane, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, editorPane, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, editorPane, 268, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, editorPane, 440, SpringLayout.WEST, getContentPane());
		try {
			editorPane.setPage(new URL(recipeURL));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getContentPane().add(editorPane);
		
		
	}		
}


