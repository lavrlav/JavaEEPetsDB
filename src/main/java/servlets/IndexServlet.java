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

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PetDAO petDAO = new PetDAO();
        List<Pet> pets = petDAO.selectAll();
        request.setAttribute("pets", pets);

        OwnerDAO ownerDAO = new OwnerDAO();
        List<Owner> owners = ownerDAO.selectAll();
        request.setAttribute("owners", owners);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
