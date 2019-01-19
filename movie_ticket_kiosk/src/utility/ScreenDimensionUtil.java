package utility;

import java.awt.Dimension;
import java.awt.Toolkit;

public class ScreenDimensionUtil {

	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public final static int DESKTOP_SCREEN_HEIGHT = screenSize.height;
	public final static int DESKTOP_SCREEN_WIDTH = screenSize.width;
	
	public final static int BUTTON_HEIGHT = (int) (DESKTOP_SCREEN_HEIGHT * 0.04);
	public final static int BUTTON_WIDTH = (int) (DESKTOP_SCREEN_WIDTH * 0.08);
	
	public final static int SCREEN_HEIGHT = (DESKTOP_SCREEN_HEIGHT / 4)*3;
	public final static int SCREEN_WIDTH = (DESKTOP_SCREEN_WIDTH / 4)*3;
	
	public final static int SCREEN_LOCATION_X = DESKTOP_SCREEN_WIDTH / 8;
	public final static int SCREEN_LOCATION_Y = 0;
}
