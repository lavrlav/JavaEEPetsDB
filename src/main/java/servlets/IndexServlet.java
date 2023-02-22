package servlets;

import pets.Pet;
import pets.PetDB;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/")
public class IndexServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Pet> pets = PetDB.select();
        request.setAttribute("pets", pets);

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
