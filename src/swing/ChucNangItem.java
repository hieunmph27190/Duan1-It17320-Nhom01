package swing;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ChucNangItem {
	private  String label;
	private  ImageIcon icon;
	private  JPanel  panelContent;
	private JButton buttonCN;
	public ChucNangItem( String label, ImageIcon icon, JPanel panelContent) {
		this.label = label;
		this.icon = icon;
		this.panelContent = panelContent;
	}

	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ImageIcon getIcon() {
		return icon;
	}
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	public JPanel getPanelContent() {
		return panelContent;
	}
	public void setPanelContent(JPanel panelContent) {
		this.panelContent = panelContent;
	}
	public void setButtonCN(JButton buttonCN) {
		this.buttonCN = buttonCN;
	}
	public JButton getButtonCN() {
		return buttonCN;
	}

}
