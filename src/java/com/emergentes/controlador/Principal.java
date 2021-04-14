
package com.emergentes.controlador;

import com.emergentes.modelo.Vacuna;
import com.emergentes.modelo.VacunaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        VacunaDAO gestor = (VacunaDAO) ses.getAttribute("gestor");
        
        if (gestor == null) {
            
            VacunaDAO auxi = new VacunaDAO();
            ses.setAttribute("gestor", auxi);
        }
        String op = request.getParameter("op");
        if (op == null) {
            op = "";
        }
        
        
        if (op.trim().equals("")) {
            response.sendRedirect("vista/listado.jsp");
        }
        if (op.trim().equals("nuevo")) {
            ses = request.getSession();
            
            Vacuna obj = new Vacuna();
            
            obj.setId(gestor.getCorrelativo()+1);
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/nuevo.jsp").forward(request, response);
        }
        
        if (op.trim().equals("editar")) {
            
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            Vacuna obj = gestor.getVacunas().get(pos);
            
            request.setAttribute("item", obj);
            request.getRequestDispatcher("vista/editar.jsp").forward(request, response);
        }
        
        if (op.trim().equals("eliminar")) {
            
            int pos = gestor.posicion(Integer.parseInt(request.getParameter("id")));
            gestor.getVacunas().remove(pos);
            
            
            response.sendRedirect("vista/listado.jsp");
        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        
        VacunaDAO gestor = (VacunaDAO) ses.getAttribute("gestor");
        Vacuna obj = new Vacuna();
        
        
        gestor.setCorrelativo(gestor.getCorrelativo()+1);
        
        obj.setId(Integer.parseInt(request.getParameter("id")));
        obj.setNombre(request.getParameter("nombre"));
        obj.setPeso(Integer.parseInt(request.getParameter("peso")));
        obj.setTalla(Integer.parseInt(request.getParameter("talla")));
        obj.setVacuna(request.getParameter("vacuna"));
       
        
        String tipo = request.getParameter("tipo");
        
        if (tipo.equals("-1")) {
            obj.setId(gestor.getCorrelativo());
            gestor.insertar(obj);
        } else {
            gestor.modificar(obj.getId(), obj);
        }
        response.sendRedirect("vista/listado.jsp");
    }
    }

   

