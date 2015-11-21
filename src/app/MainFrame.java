package app;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4826439770618099371L;
	private DetailsPanel detailsPanel;

	public MainFrame(String title) {
		super(title);

		// set layout manager
		setLayout(new BorderLayout());

		// create swing component
		final JTextArea textArea = new JTextArea();

		detailsPanel = new DetailsPanel();

		detailsPanel.addDetailsListener(new DetailListener() {
			public void DetailEventOccured(DetailEvent event) {
				String text = event.getText();

				textArea.append(text);
			}

		});

		// add swing components to content pane
		Container c = getContentPane();
		c.add(textArea, BorderLayout.CENTER);
		c.add(detailsPanel, BorderLayout.WEST);

	}

}
