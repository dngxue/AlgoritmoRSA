package utils;

import javax.swing.Icon;
import org.kordamp.ikonli.fontawesome5.FontAwesomeSolid;
import org.kordamp.ikonli.swing.FontIcon;

public class FontAwesomeIcons {  
  public static Icon backIcon(int size) {
    FontIcon icon = FontIcon.of(FontAwesomeSolid.ARROW_LEFT, size);
    icon.setIconColor(AppColors.SECONDARY_COLOR);
    return icon;
  }
  
  public static Icon getLock(int size) {
    FontIcon icon = FontIcon.of(FontAwesomeSolid.LOCK, size);
    icon.setIconColor(AppColors.getPRIMARY_COLOR());
    return icon;
  }
  
  public static Icon getSuccess(int size) {
    FontIcon icon = FontIcon.of(FontAwesomeSolid.CHECK_CIRCLE, size);
    icon.setIconColor(AppColors.getPRIMARY_COLOR());
    return icon;
  }
}