package app;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = -4826439770618099371L;
	private UpperPanel upperPanel;
	private LowerPanel lowerPanel;
	private RightPanel rightPanel;

	public MainFrame(String title) {
		super(title);

		// set layout manager
		setLayout(new BorderLayout());

		// create swing component
		final JTextArea textArea = new JTextArea();
		textArea.setSize(400, 400);
		textArea.setLineWrap(true);
		textArea.setEditable(true);
		textArea.setVisible(true);
		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		rightPanel = new RightPanel();
		lowerPanel = new LowerPanel();
		upperPanel = new UpperPanel();

		lowerPanel.addDetailsListener(new DetailListener() {
			@Override
			public void DetailEventOccured(DetailEvent event) {
				// TODO Auto-generated method stub
				String text = event.getText();
				textArea.append(text);
			}
		});

		upperPanel.addDetailsListener(new DetailListener() {
			public void DetailEventOccured(DetailEvent event) {
				String text = event.getText();
				textArea.append(text);
			}
		});

		// add swing components to content pane
		Container c = getContentPane();
		c.add(scroll, BorderLayout.CENTER);
		c.add(upperPanel, BorderLayout.NORTH);
		c.add(lowerPanel, BorderLayout.SOUTH);
		c.add(rightPanel, BorderLayout.EAST);
	}
}
