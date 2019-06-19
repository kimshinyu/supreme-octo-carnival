package supremeUtils;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JTextField;

public class STextField extends InputStream{
    private static final STextField INSTANCE = new STextField();
    private static final InputStream IN;
    private static JTextField inReader;
    private static boolean TAINTED = false;
    static {
    	IN = System.in;
        System.setIn(new CustomInputStream(new STextField()));
    }
    
    /** Creates a new instance of TextAreaOutputStream. */
    private STextField() {}
  
    /** Gets the output stream. */
    public static STextField getInstance(JTextField textField) {
    	inReader = textField;
        return INSTANCE;
    }
  
    /** Gets the functioning console output.
      * @see java.lang.System.out
      */
    public static InputStream getOldSystemOut() {
        return IN;
    }
  
    /** Determines if output has occured. */
    public static boolean isTainted() {
        return TAINTED;
    }
  
    @Override
    public int read() throws IOException {
    	return System.in.read();
    }
}

class CustomInputStream extends InputStream {

    public CustomInputStream(InputStream input) {
    }

    public int read() {
    	return 0;
    }

}
