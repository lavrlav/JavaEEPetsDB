package servlets;

import pets.Pet;
import pets.PetDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String animal = request.getParameter("animal");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color= request.getParameter("color");
            int ownerId = Integer.parseInt(request.getParameter("ownerId"));
            Pet pet= new Pet(animal, name, age, color, ownerId);
            PetDB.insert(pet);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
