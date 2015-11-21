package app;

import java.util.EventListener;

public interface DetailListener extends EventListener {
	public void DetailEventOccured(DetailEvent event);
}
