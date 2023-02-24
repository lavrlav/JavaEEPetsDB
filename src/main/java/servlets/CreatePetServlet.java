package servlets;

import dao.PetDAO;
import entity.Pet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/createPet")
public class CreatePetServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createPet.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
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
            response.sendRedirect(request.getContextPath() + "/information");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/createPet.jsp").forward(request, response);
        }

    }
}
