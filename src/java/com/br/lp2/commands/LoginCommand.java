package com.br.lp2.commands;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruce
 */
public class LoginCommand implements Command {

    private String senha;
    private String usuario;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        usuario = request.getParameter("usuario");
        senha = request.getParameter("senha");

        //validação simples apenas para teste
        if (usuario.equals("admin") && senha.equals("admin")) {
            try {
                HttpSession session = request.getSession();
                session.setAttribute("usuario", usuario);
                session.setAttribute("senha", senha);

                request.getRequestDispatcher("menu_principal.html").forward(request, response);
            } catch (ServletException | IOException ex) {
                Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
