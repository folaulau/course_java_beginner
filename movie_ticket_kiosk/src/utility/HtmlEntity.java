package utility;

public class HtmlEntity {

	
	public static final String TAB = "&#9;";
	public static final String SPACE = "&nbsp;";
	
	public static String getTabs(int count) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<count;i++) {
			str.append(TAB);
		}
		return str.toString();
	}
	
	public static String getSpaces(int count) {
		StringBuilder str = new StringBuilder();
		for(int i=0;i<count;i++) {
			str.append(SPACE);
		}
		return str.toString();
	}
}
