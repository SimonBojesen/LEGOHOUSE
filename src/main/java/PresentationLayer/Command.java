package PresentationLayer;

import Exceptions.InputException;
import Exceptions.WritingToSQLException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "makeorder", new MakeOrder() );
        commands.put( "vieworders", new ViewOrders() );
        commands.put( "vieworder", new ViewOrder() );
        commands.put( "isSent", new isSent() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute( HttpServletRequest request, HttpServletResponse response ) 
            throws WritingToSQLException, InputException;

}
