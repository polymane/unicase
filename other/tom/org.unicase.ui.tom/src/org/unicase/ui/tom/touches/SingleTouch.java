package org.unicase.ui.tom.touches;

import java.util.Date;
import java.util.List;

import org.eclipse.draw2d.geometry.PointList;

public abstract class SingleTouch extends AbstractTouch{

	private Date touchUpDate = new Date(-1);
	private Date touchDownDate = new Date(-1);

	
	public SingleTouch() {
	}
	
	public abstract PointList getPath();
	

	public void setTouchUpDate(Date touchUpDate) {
		this.touchUpDate = touchUpDate;
	}

	public Date getTouchUpDate() {
		return touchUpDate;
	}

	public void setTouchDownDate(Date touchDownDate) {
		this.touchDownDate = touchDownDate;
	}

	public Date getTouchDownDate() {
		return touchDownDate;
	}
	
	public abstract void update();
}
