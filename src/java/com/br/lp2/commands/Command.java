package com.br.lp2.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Gilson da Silva
 * @version 1.0
 */
public interface Command {
    
    public void execute(HttpServletRequest request, HttpServletResponse response);    
}
