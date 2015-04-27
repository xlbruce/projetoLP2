package com.br.lp2.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public class EditarAtorCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        try {
            //Desenhar a pagina de edição de ator
            request.getRequestDispatcher("manutencao/atores/editar_atores.jsp").forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(EditarAtorCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EditarAtorCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
