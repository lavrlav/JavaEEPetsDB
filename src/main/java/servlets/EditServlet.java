package servlets;

import dao.OwnerDAO;
import dao.PetDAO;
import entity.Owner;
import entity.Pet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private final OwnerDAO ownerDAO = new OwnerDAO();
    private final PetDAO petDAO = new PetDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (ownerDAO.selectOne(id) != null) {
                request.setAttribute("owner", ownerDAO.selectOne(id));
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (petDAO.selectOne(id) != null) {
                request.setAttribute("pet", petDAO.selectOne(id));
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Owner owner = Owner.builder()
                    .id(id)
                    .name(name)
                    .build();
            ownerDAO.update(owner, id);
            response.sendRedirect(request.getContextPath() + "/information");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
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
            response.sendRedirect(request.getContextPath() + "/information");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }

}
