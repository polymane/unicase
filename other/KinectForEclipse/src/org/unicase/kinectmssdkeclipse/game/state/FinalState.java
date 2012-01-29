package org.unicase.kinectmssdkeclipse.game.state;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class FinalState implements GameState {

	@Override
	public Gesture getRequiredGesture() {
		return Gesture.JUMP;
	}

	@Override
	public void performAction() {

	}

	@Override
	public void paintScreen(final Label label) {
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				label.setText("Thanks.. Reset to play again");
			}
		});
	}

	@Override
	public String getRequiredSpeechString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isGestureEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSpeechEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
}
