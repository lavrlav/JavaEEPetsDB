package servlets;

import dao.PetDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/deletePet")
public class DeletePetServlet extends HttpServlet {
    private final PetDAO petDAO = new PetDAO();

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                int id = Integer.parseInt(request.getParameter("id"));
                petDAO.delete(id);
                response.sendRedirect(request.getContextPath() + "/index");
            }
            catch(Exception ex) {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
            }
    }
}
