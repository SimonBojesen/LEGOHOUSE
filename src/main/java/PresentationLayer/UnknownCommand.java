package PresentationLayer;

import Exceptions.WritingToSQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UnknownCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws WritingToSQLException {
        String msg = "Unknown command. Contact IT";
        throw new WritingToSQLException( msg );
    }

}
