import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class RecipeCell extends JPanel {

	private Recipe panelRecipe;
	private JLabel image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));;
	private BufferedImage bufferedImage;
	private JLabel recipeTitle;
	private String ID;
	private int index;
	
	public RecipeCell(Recipe panelRecipe) {
		
		this.index = RecipeArray.getInstance().indexOf(panelRecipe);
		if(panelRecipe != null){			
			this.setPanelRecipe(panelRecipe);
		}
		else{ // don't create recipe panel
			return;
		}
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
//		Mouse Listener
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = getIndex() ;
				System.out.println("\n" + index);
				RecipeRequest newRecipeRequest = new RecipeRequest(RecipeArray.getInstance().get(index).getID());
				try {
					RecipeArray.getInstance().get(index).setDetails(newRecipeRequest.getRecipe());
					
//					Desktop.getDesktop().browse(panelRecipe.getRecipeURL().toURI());
			
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setBorder(new LineBorder(new Color(153, 153, 153)));
			
		try {
			bufferedImage = ImageIO.read(panelRecipe.getImageURL());
			image.setIcon(new ImageIcon(bufferedImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		recipeTitle = new JLabel(panelRecipe.getRecipeName());
		recipeTitle.setFont(new Font("Arial", Font.PLAIN, 13));
		recipeTitle.setHorizontalAlignment(SwingConstants.CENTER);
		
		GridBagConstraints gbc_image = new GridBagConstraints();
		gbc_image.gridheight = 3;
		gbc_image.fill = GridBagConstraints.BOTH;
		gbc_image.anchor = GridBagConstraints.WEST;
		gbc_image.insets = new Insets(0, 0, 0, 0);
		gbc_image.gridx = 0;
		gbc_image.gridy = 0;
		add(image, gbc_image);
		
		GridBagConstraints gbc_recipeTitle = new GridBagConstraints();
		gbc_recipeTitle.insets = new Insets(5, 0, 0, 0);
		gbc_recipeTitle.fill = GridBagConstraints.HORIZONTAL;
		gbc_recipeTitle.anchor = GridBagConstraints.CENTER;
		gbc_recipeTitle.gridx = 1;
		gbc_recipeTitle.gridy = 0;
		add(recipeTitle, gbc_recipeTitle);

	}
	
	public void Refresh(Recipe panelRecipe){
		try {
			bufferedImage = ImageIO.read(panelRecipe.getImageURL());
			image.setIcon(new ImageIcon(bufferedImage));
		} catch (IOException e) {
			e.printStackTrace();
		}
		recipeTitle.setText(panelRecipe.getRecipeName());
		
	}

	public Recipe getPanelRecipe() {
		return panelRecipe;
	}

	public void setPanelRecipe(Recipe panelRecipe) {
		this.panelRecipe = panelRecipe;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

