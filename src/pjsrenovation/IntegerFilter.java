
package pjsrenovation;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;
import javafx.scene.control.TextFormatter;

/**
 *
 * @author Admin
 */
public class IntegerFilter implements  UnaryOperator<TextFormatter.Change>{
private final static Pattern DIGIT_PATTERN = Pattern.compile("\\d*");
    @Override
    public TextFormatter.Change apply(TextFormatter.Change t) {
        return DIGIT_PATTERN.matcher(t.getText()).matches() ? t : null;
    }
    
}
