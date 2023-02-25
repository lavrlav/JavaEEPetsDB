package servlets;

import dao.OwnerDAO;
import dao.PetDAO;
import entity.Owner;
import entity.Pet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();
    private final OwnerDAO ownerDAO = new OwnerDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Pet> pets = petDAO.selectAll();
        request.setAttribute("pets", pets);

        List<Owner> owners = ownerDAO.selectAll();
        request.setAttribute("owners", owners);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }


