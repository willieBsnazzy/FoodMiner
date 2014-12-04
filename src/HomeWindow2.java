import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.Font;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;

import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.JSlider;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

import javax.swing.event.ChangeListener;

import java.awt.SystemColor;
import java.awt.Cursor;


public class HomeWindow2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GridBagLayout gbl_contentPane = new GridBagLayout();
	private JPanel contentPane;
	private final JTextField txtSearch = new JTextField();
	private JButton btnAdvancedSearch = new JButton("Advanced Options");

	
	// Creating Jlabels and style constraints 
	private JLabel R1Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R1Title = new JLabel();
	private JLabel R2Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R2Title = new JLabel();
	private JLabel R3Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R3Title = new JLabel();
	private JLabel R4Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R4Title = new JLabel();
	private JLabel R5Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R5Title = new JLabel();
	private JLabel R6Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R6Title = new JLabel();
	private JLabel R7Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R7Title = new JLabel();
	private JLabel R8Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R8Title = new JLabel();
	private JLabel R9Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R9Title = new JLabel();
	private JLabel R10Image = new JLabel(new ImageIcon (getClass().getResource("/Resources/brokenLinkIcon.png")));
	private JLabel R10Title = new JLabel();
	private JLabel RecipeImages[] = {R1Image, R2Image, R3Image, R4Image, R5Image, R6Image, R7Image, R8Image, R9Image, R10Image};
	private JLabel Titles[] = {R1Title, R2Title, R3Title, R4Title, R5Title, R6Title, R7Title, R8Title, R9Title, R10Title};
	private GridBagConstraints gbc_newRecipe1, gbc_newRecipe2, gbc_newRecipe3, gbc_newRecipe4, gbc_newRecipe5, gbc_newRecipe6, gbc_newRecipe7, gbc_newRecipe8, gbc_newRecipe9, gbc_newRecipe10;
	private GridBagConstraints gbc_newRecipes[] = {gbc_newRecipe1, gbc_newRecipe2, gbc_newRecipe3, gbc_newRecipe4, gbc_newRecipe5, gbc_newRecipe6, gbc_newRecipe7, gbc_newRecipe8, gbc_newRecipe9, gbc_newRecipe10};
	private RecipeCell newRecipe1, newRecipe2, newRecipe3, newRecipe4, newRecipe5, newRecipe6, newRecipe7, newRecipe8, newRecipe9, newRecipe10;
	private RecipeCell newRecipes[] = {newRecipe1, newRecipe2, newRecipe3, newRecipe4, newRecipe5, newRecipe6, newRecipe7, newRecipe8, newRecipe9, newRecipe10};
	private int index;
	private GridBagConstraints gbc_panel_1 = new GridBagConstraints();
	private int searchType = 0;
	private BufferedImage BufferedImages[] = new BufferedImage[10];
	private JScrollPane scrollPane = new JScrollPane();
	private JPanel panel_2 = new JPanel();
	private JPanel AdvancedPanel = new JPanel();
	private final JRadioButton rdbtnKeywords = new JRadioButton("Keywords");
	private final JRadioButton rdbtnIngredients = new JRadioButton("Ingredients");
	private final JRadioButton rdbtnExcludeIngredients = new JRadioButton("Exclude Ingredients");
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final JSlider calSlider = new JSlider();
	private final JTextField txtKcal = new JTextField();
	


	public HomeWindow2() {
		txtKcal.setEditable(false);
		txtKcal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtKcal.setHorizontalAlignment(SwingConstants.LEFT);
		txtKcal.setBackground(SystemColor.window);
		txtKcal.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtKcal.setText("Kcal");
		txtKcal.setColumns(1);
		setTitle("FoodMiner©");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 600, 800);
		contentPane = new JPanel();
		contentPane.setAlignmentY(Component.TOP_ALIGNMENT);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagConstraints c = new GridBagConstraints();
		gbl_contentPane.rowHeights = new int[] {250, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridy = 0;
		gbc_panel.gridx = 0;
		contentPane.add(panel, gbc_panel);
		
		BufferedImage TitleBar = null;
		try{
			TitleBar = ImageIO.read(getClass().getResource("/Resources/titleBarlogo.png"));
		}catch(Exception e){
			System.out.println(e + " could not find file>>>>>>");
		}
		for(int i= 0; i < RecipeArray.getInstance().getTotalMatchCount() && i<10 ; i++){
			try{
				URL imageURL = RecipeArray.getInstance().get(i).getImageURL();
				BufferedImages[i] = ImageIO.read(imageURL);
			}catch(Exception e){
				System.out.println(e);
			}
		}
		
		
		JLabel lblTitleBar = new JLabel(new ImageIcon(TitleBar));
		lblTitleBar.setAlignmentY(Component.TOP_ALIGNMENT);
		lblTitleBar.setBounds(new Rectangle(0, 0, 600, 250));
		lblTitleBar.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitleBar.setVerticalAlignment(SwingConstants.TOP);
		c.gridwidth = 1;
		FlowLayout fl_panel = new FlowLayout(FlowLayout.CENTER, 0, 0);
		fl_panel.setAlignOnBaseline(true);
		panel.setLayout(fl_panel);
		panel.add(lblTitleBar);
		txtSearch.setMargin(new Insets(0, 50, 0, 50));
		txtSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txtSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		txtSearch.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtSearch.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			// Check for search type 
			if(rdbtnKeywords.isSelected())searchType = 0;
			if(rdbtnIngredients.isSelected())searchType = 1;
			if(rdbtnExcludeIngredients.isSelected())searchType = 2;
			
			RecipeArray.getInstance().clear();
			Search newSearch = new Search(txtSearch.getText());
			newSearch.setSearchType(searchType);
			
			if(newSearch.getKeywords().equals("")){
				JOptionPane.showMessageDialog(null, 
						"No recipes found for: " + newSearch.getKeywords().replace("%5B", " "),
						"No Results", JOptionPane.WARNING_MESSAGE);
			}
			Request newResults = new Request(newSearch);
			try {
				RecipeArray.getInstance().fillArray(newResults.sendPost());
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("failed filling RecipeArray");
			}
			if(RecipeArray.getInstance().getTotalMatchCount() > 0){
				try{

					for(int i = 0; i < RecipeArray.getInstance().getTotalMatchCount() && i<10 ; i++){
					
						newRecipes[i].Refresh(RecipeArray.getInstance().get(i));;
						panel_2.validate();
						panel_2.repaint();
					}
				}catch(Exception e1){
					System.out.println(e1 + " nope");
				}
			}
			else{
				JOptionPane.showMessageDialog(null, 
						"No recipes found for: " + newSearch.getKeywords().replace("%5B", " "),
						"No Results", JOptionPane.WARNING_MESSAGE);
			}
		}
		});
		
		txtSearch.setForeground(UIManager.getColor("CheckBox.disabledText"));
		txtSearch.setText("Search Recipes, ingredients...");
		GridBagConstraints gbc_txtSearch = new GridBagConstraints();
		gbc_txtSearch.insets = new Insets(0, 30, 5, 0);
		gbc_txtSearch.ipady = 10;
		gbc_txtSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch.gridx = 0;
		gbc_txtSearch.gridy = 1;
		contentPane.add(txtSearch, gbc_txtSearch);
		txtSearch.setColumns(1);
		
		gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 3;
		
		contentPane.add(AdvancedPanel, gbc_panel_1);
		
		GridBagLayout gbl_AdvancedPanel = new GridBagLayout();
		gbl_AdvancedPanel.columnWidths = new int[] {0};
		gbl_AdvancedPanel.rowHeights = new int[] {0};
		gbl_AdvancedPanel.columnWeights = new double[]{1.0, 0.0, 0.0};
		gbl_AdvancedPanel.rowWeights = new double[]{0.0, 0.0};
		AdvancedPanel.setLayout(gbl_AdvancedPanel);
		
		buttonGroup.add(rdbtnKeywords);
		rdbtnKeywords.setHorizontalAlignment(SwingConstants.LEFT);
		rdbtnKeywords.setAlignmentX(Component.CENTER_ALIGNMENT);
		rdbtnKeywords.setSelected(true);
		GridBagConstraints gbc_rdbtnKeywords = new GridBagConstraints();
		gbc_rdbtnKeywords.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnKeywords.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnKeywords.gridx = 0;
		gbc_rdbtnKeywords.gridy = 0;
		AdvancedPanel.add(rdbtnKeywords, gbc_rdbtnKeywords);
		
		buttonGroup.add(rdbtnIngredients);
		GridBagConstraints gbc_rdbtnIngredients = new GridBagConstraints();
		gbc_rdbtnIngredients.anchor = GridBagConstraints.WEST;
		gbc_rdbtnIngredients.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnIngredients.gridx = 1;
		gbc_rdbtnIngredients.gridy = 0;
		AdvancedPanel.add(rdbtnIngredients, gbc_rdbtnIngredients);
		
		buttonGroup.add(rdbtnExcludeIngredients);
		GridBagConstraints gbc_rdbtnExcludeIngredients = new GridBagConstraints();
		gbc_rdbtnExcludeIngredients.anchor = GridBagConstraints.WEST;
		gbc_rdbtnExcludeIngredients.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnExcludeIngredients.gridx = 2;
		gbc_rdbtnExcludeIngredients.gridy = 0;
		AdvancedPanel.add(rdbtnExcludeIngredients, gbc_rdbtnExcludeIngredients);
		
		GridBagConstraints gbc_txtKcal = new GridBagConstraints();
		gbc_txtKcal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKcal.insets = new Insets(0, 10, 0, 5);
		gbc_txtKcal.gridx = 0;
		gbc_txtKcal.gridy = 1;
		AdvancedPanel.add(txtKcal, gbc_txtKcal);
		calSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtKcal.setText("Calories/ser " + calSlider.getValue());
			}
		});
		calSlider.setMaximum(2000);
		
		calSlider.setValue(2000);
		GridBagConstraints gbc_calSlider = new GridBagConstraints();
		gbc_calSlider.insets = new Insets(0, 0, 0, 0);
		gbc_calSlider.anchor = GridBagConstraints.WEST;
		gbc_calSlider.gridx = 1;
		gbc_calSlider.gridy = 1;
		AdvancedPanel.add(calSlider, gbc_calSlider);
		
		GridBagConstraints gbc_btnAdvancedSearch = new GridBagConstraints();
		gbc_btnAdvancedSearch.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdvancedSearch.insets = new Insets(10, 0, 10, 30);
		gbc_btnAdvancedSearch.gridx = 0;
		gbc_btnAdvancedSearch.gridy = 2;
		btnAdvancedSearch.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnAdvancedSearch.setFont(new Font("Arial", Font.PLAIN, 16));

		btnAdvancedSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(btnAdvancedSearch.getText() == "Advanced Options"){
					gbl_contentPane.rowHeights = new int[] {250, 0, 0, 0};
					contentPane.add(AdvancedPanel, gbc_panel_1);
					btnAdvancedSearch.setText("Basic Options");
					contentPane.revalidate();
					contentPane.repaint();
				}
				else{
					gbl_contentPane.rowHeights = new int[] {250, 0, 0, 0};
					contentPane.remove(AdvancedPanel);
					btnAdvancedSearch.setText("Advanced Options");
					contentPane.revalidate();
					contentPane.repaint();
				}
			}
		});
		contentPane.add(btnAdvancedSearch, gbc_btnAdvancedSearch);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 4;
		
		panel_2.setBorder(null);
		scrollPane.setViewportView(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		for(int i =0; i < RecipeArray.getInstance().getTotalMatchCount() && i<10 ; i++){
			
			newRecipes[i] = new RecipeCell(RecipeArray.getInstance().get(i));
			gbc_newRecipes[i] = new GridBagConstraints();
			gbc_newRecipes[i].fill = GridBagConstraints.BOTH;
			gbc_newRecipes[i].gridx = 0;
			gbc_newRecipes[i].gridy = i;
			panel_2.add(newRecipes[i], gbc_newRecipes[i]);	
		}
		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, gbc_scrollPane);		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search mySearch = new Search("");
					Request myRequest = new Request( mySearch);
					RecipeArray.getInstance().fillArray(myRequest.sendPost());
				
					HomeWindow2 frame = new HomeWindow2();
					frame.setVisible(true);
					
					// test code for viewing websites 
//					Desktop.getDesktop().browse(new URI("http://www.yummly.com"));
//					RecipeWebSite testsite = new RecipeWebSite("http://www.yummly.com");
//					testsite.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
