package com.br.lp2.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class AdicionarAtorCommand implements Command {

    private String command;
    
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        command = request.getParameter("command");
        try {
            request.getRequestDispatcher("manutencao/atores/editar_ator.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(AdicionarAtorCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AdicionarAtorCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(command.equals("AdicionarAtorCommand")) {
            //TODO
            //desenhar a page que adiciona um ator
        }
    }
    
}
