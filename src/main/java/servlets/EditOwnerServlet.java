package servlets;

import dao.OwnerDAO;
import entity.Owner;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/editOwner")
public class EditOwnerServlet extends HttpServlet {
    private final OwnerDAO ownerDAO = new OwnerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int id = Integer.parseInt(request.getParameter("id"));
            if (ownerDAO.selectOne(id) != null) {
                request.setAttribute("owner", ownerDAO.selectOne(id));
                getServletContext().getRequestDispatcher("/editOwner.jsp").forward(request, response);
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
            String name = request.getParameter("name");
            Owner owner = Owner.builder()
                    .id(id)
                    .name(name)
                    .build();
            ownerDAO.update(owner, id);
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (Exception ex) {

            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
        }
    }
}
