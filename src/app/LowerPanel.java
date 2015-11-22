package app;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

public class LowerPanel extends JPanel {

	private static final long serialVersionUID = 5791640034089333284L;

	private EventListenerList listenerList = new EventListenerList();

	public LowerPanel() {
		Dimension size = getPreferredSize();
		size.width = 500;
		size.height = 50;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Data File"));

		JButton btnOpen = new JButton("open");
		JButton btnClose = new JButton("close");

		btnOpen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tOpen = RightPanel.fOpen.getText();
				String text = tOpen + "\n ";
				fireDetailEvent(new DetailEvent(this, text));
			}
		});
		
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tClose = RightPanel.fClose.getText();
				String text = tClose + "\n ";
				fireDetailEvent(new DetailEvent(this, text));
				
			}
		});

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridwidth = 7;
		gc.gridheight = 1;
		gc.weightx = 1;
		gc.weighty = 1;

		//// final row
		gc.anchor = GridBagConstraints.CENTER;// LINE_START; // ;
		gc.gridx = 0;
		gc.gridy = 1;
		add(btnOpen, gc);

		//// final row
		gc.gridx = 10;
		gc.gridy = 1;
		add(btnClose, gc);
	}

	public void fireDetailEvent(DetailEvent event) {
		Object[] listeners = listenerList.getListenerList();
		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == DetailListener.class) {
				((DetailListener) listeners[i + 1]).DetailEventOccured(event);
			}
		}
	}

	public void addDetailsListener(DetailListener listener) {
		listenerList.add(DetailListener.class, listener);
	}

	public void removeDetailsListener(DetailListener listener) {
		listenerList.remove(DetailListener.class, listener);

	}
}
