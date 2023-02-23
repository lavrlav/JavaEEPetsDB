package servlets;

import dao.OwnerDAO;
import dao.PetDAO;
import entity.Owner;
import entity.Pet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            PetDAO petDAO = new PetDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            String animal = request.getParameter("animal");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            String color = request.getParameter("color");
            int ownerId = Integer.parseInt(request.getParameter("ownerId"));
            Pet pet = Pet.builder()
                    .id(id)
                    .animal(animal)
                    .name(name)
                    .age(age)
                    .color(color)
                    .ownerId(ownerId)
                    .build();
            petDAO.create(pet);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
        try {
            OwnerDAO ownerDAO = new OwnerDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Owner owner = Owner.builder()
                    .id(id)
                    .name(name)
                    .build();
            ownerDAO.create(owner);
            response.sendRedirect(request.getContextPath()+"/index");
        }
        catch(Exception ex) {

            getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
        }
    }
}
