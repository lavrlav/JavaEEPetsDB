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
import java.util.List;

@WebServlet("/information")
public class InformationServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();
    private final OwnerDAO ownerDAO = new OwnerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        List<Pet> pets = petDAO.selectAll();
        request.setAttribute("pets", pets);

        List<Owner> owners = ownerDAO.selectAll();
        request.setAttribute("owners", owners);

        getServletContext().getRequestDispatcher("/information.jsp").forward(request, response);

    }

}
