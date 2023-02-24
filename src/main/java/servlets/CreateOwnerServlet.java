package servlets;

import dao.OwnerDAO;
import entity.Owner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/createOwner")
public class CreateOwnerServlet extends HttpServlet {

    private final OwnerDAO ownerDAO = new OwnerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/createOwner.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            Owner owner = Owner.builder()
                    .id(id)
                    .name(name)
                    .build();
            ownerDAO.create(owner);
            response.sendRedirect(request.getContextPath() + "/information");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/createOwner.jsp").forward(request, response);
        }
    }
}
