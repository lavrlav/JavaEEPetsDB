package servlets;

import dao.PetDAO;
import entity.Pet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/editPet")
public class EditPetServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (petDAO.selectOne(id) != null) {
                request.setAttribute("pet", petDAO.selectOne(id));
                getServletContext().getRequestDispatcher("/editPet.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
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
            petDAO.update(pet, id);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
