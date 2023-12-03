package Backend;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InputListener implements ActionListener {
    final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    public void actionPerformed(ActionEvent e) {
        logger.log(Level.INFO, "Action Event registered.");
    }
}
