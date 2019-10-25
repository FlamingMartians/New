import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ReturnPressKeyListener implements KeyListener {
	private ActionListener listener;
	private Component component;
	
	public ReturnPressKeyListener(ActionListener listener, Component component) {
		this.listener = listener;
		this.component = component;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			this.listener.actionPerformed(new ActionEvent(component, 0, "add"));
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
