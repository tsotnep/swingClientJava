package app;

import java.util.EventObject;

public class DetailEvent extends EventObject {
	private static final long serialVersionUID = 5518624145024611596L;
	private String text;

	public DetailEvent(Object source, String text) {
		super(source);
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
