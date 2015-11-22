
package app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RightPanel extends JPanel {

	private static final long serialVersionUID = -1613830215648734608L;

	final static JTextField fBreak = new JTextField("fBreak", 10);
	final static JTextField fConnect = new JTextField("fConnect", 10);
	final static JTextField fOpen = new JTextField("fOpen", 10);
	final static JTextField fClose = new JTextField("fClose", 10);

	public RightPanel() {
		Dimension size = getPreferredSize();
		size.width = 200;
		size.height = 400;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("TEST"));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridwidth = 5;
		gc.gridheight = 10;
		gc.weightx = 1;
		gc.weighty = 1;

		//// second column
		gc.anchor = GridBagConstraints.PAGE_START;
		gc.weighty = 1;
		gc.gridx = 2;
		gc.gridy = 0;
		add(fBreak, gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 4;
		add(fConnect, gc);

		gc.anchor = GridBagConstraints.CENTER;
		gc.weighty = 0.5;
		gc.gridx = 2;
		gc.gridy = 10;
		add(fOpen, gc);

		gc.anchor = GridBagConstraints.PAGE_END;
		gc.weighty = 1;
		gc.gridx = 2;
		gc.gridy = 10;
		add(fClose, gc);

	}
}
