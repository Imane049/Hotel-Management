package Servlets;

import java.io.IOException;

import org.hibernate.SessionFactory;

import com.jsp.dao.RoomDao;
import com.jsp.dto.Room;
import com.jsp.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AvailabilityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private SessionFactory sessionFactory;

    @Override
    public void init() throws ServletException {
        // Initialize Hibernate SessionFactory (You need to set up Hibernate configuration)
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve form parameters
        String checkinDate = request.getParameter("checkinDate");
        String checkoutDate = request.getParameter("checkoutDate");
        String roomType = request.getParameter("roomType");

        // Query Hibernate to check for available rooms
        RoomDao roomDao = new RoomDao(sessionFactory);
        Room availableRoom = roomDao.getFirstAvailableRoom(checkinDate, checkoutDate, roomType);

        if (availableRoom != null) {
            // Forward the request to the JSP page that will display the available room
            request.setAttribute("availability", availableRoom);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/availablity.jsp");
            dispatcher.forward(request, response);
        } else {
            // If no available room, you can redirect to an error page or handle it accordingly
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    public void destroy() {
        // Close Hibernate SessionFactory during servlet destruction
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
