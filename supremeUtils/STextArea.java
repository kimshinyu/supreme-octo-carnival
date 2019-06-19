package supremeUtils;

import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JTextArea;

public class STextArea extends OutputStream {
    private static final STextArea INSTANCE = new STextArea();
    private static final PrintStream OUT;
    private static JTextArea outWriter;
    private static boolean TAINTED = false; //I don't really get this yet, it's supposed to tell if output has been done
    static {
        OUT = System.out;
        System.setOut(new PrintStream(new STextArea()));
    }
    
    /** Creates a new instance of TextAreaOutputStream. */
    private STextArea() {}
  
    /** Gets the output stream. */
    public static STextArea getInstance(JTextArea textArea) {
        outWriter = textArea;
        return INSTANCE;
    }
  
    /** Gets the functioning console output.
      * @see java.lang.System.out
      */
    public static PrintStream getOldSystemOut() {
        return OUT;
    }
  
    /** Determines if output has occurred. */
    public static boolean isTainted() {
        return TAINTED;
    }
  
    /** Write output to the Text Area. */
    public void write(int param) {
        outWriter.setText(outWriter.getText() + (char)param);
        TAINTED = true;
    }
		
}