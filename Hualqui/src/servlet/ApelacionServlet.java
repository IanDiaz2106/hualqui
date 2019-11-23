package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.ApelacionesDAO;
import tablas.Apelacion;

/**
 * Servlet implementation class ApelacionServlet
 */
@WebServlet("/")
public class ApelacionServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    private ApelacionesDAO ApelacionesDAO;

    public void init() {
    	ApelacionesDAO = new ApelacionesDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertApelacion(request, response);
                    break;
                case "/delete":
                    deleteApelacion(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateApelacion(request, response);
                    break;
                default:
                    listApelacion(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listApelacion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Apelacion > listApelacion = ApelacionesDAO.getAllApelacion();
        request.setAttribute("listApelacion", listApelacion);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ListarApelacion.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Apelacion existingUser = ApelacionesDAO.getApelacion(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertApelacion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int idApelacion = Integer.parseInt(request.getParameter("id"));
        String motivo = request.getParameter("motivo");
        String estado = request.getParameter("estado");
        Apelacion newApelacion = new Apelacion(idApelacion, motivo, estado);
        ApelacionesDAO.saveApelacion(newApelacion);
        response.sendRedirect("list");
    }

    private void updateApelacion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
    	int idApelacion = Integer.parseInt(request.getParameter("id"));
        String motivo = request.getParameter("motivo");
        String estado = request.getParameter("estado");

        Apelacion newApelacion = new Apelacion(idApelacion, motivo, estado);
        ApelacionesDAO.updateApelacion(newApelacion);
        response.sendRedirect("list");
    }

    private void deleteApelacion(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ApelacionesDAO.deleteApelacion(id);
        response.sendRedirect("list");
    }
}
