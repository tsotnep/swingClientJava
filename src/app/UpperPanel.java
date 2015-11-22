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

public class UpperPanel extends JPanel {

	private static final long serialVersionUID = -1613830215648734608L;

	private EventListenerList listenerList = new EventListenerList();

	public UpperPanel() {
		Dimension size = getPreferredSize();
		size.width = 500;
		size.height = 50;
		setPreferredSize(size);

		setBorder(BorderFactory.createTitledBorder("Connection"));

		JButton btnBreak = new JButton("break");
		JButton btnConnect = new JButton("connect");

		btnBreak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tBreak = RightPanel.fBreak.getText();
				String text = tBreak + "\n ";
				fireDetailEvent(new DetailEvent(this, text));
			}
		});

		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String tConnect = RightPanel.fConnect.getText();
				String text = tConnect + "\n ";
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
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 0;
		gc.gridy = 1;
		add(btnBreak, gc);

		//// final row
		gc.weighty = 0.5;
		gc.anchor = GridBagConstraints.CENTER;
		gc.gridx = 10;
		gc.gridy = 1;
		add(btnConnect, gc);
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
