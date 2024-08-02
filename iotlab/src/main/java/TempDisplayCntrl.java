

import java.io.IOException;
import java.util.ArrayList;

import iotlab.TempDTO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TempDisplayCntrl
 */
@WebServlet("/TempDisplayCntrl")
public class TempDisplayCntrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TempDisplayCntrl() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//print all temperature collected from sensors
		
		//add temperature sent by temp sensors to the list
				ServletContext ctx = getServletContext();
				try {
				ArrayList<TempDTO> list = (ArrayList<TempDTO>)ctx.getAttribute("tempList");
				System.out.println("---------------Begin:Temerature List-----------");
				for(TempDTO tempDTO:list) {
					
					tempDTO.display();
					
				}
				System.out.println("---------------End:Temerature List----------------");
				
				
				response.getWriter().print("<html>");
				response.getWriter().print("<head>");
				response.getWriter().print("<meta http-equiv=\"refresh\" content=\"10\">");
				response.getWriter().print("</head>");
				response.getWriter().print("<table border=\"1\">");
				response.getWriter().print("<tr><td>Temerature</td>");
				response.getWriter().print("<td>DeviceId</td></tr>");
				for (TempDTO tempDTO : list) {
					response.getWriter().println("<tr>");
				 response.getWriter().println("<td>"+tempDTO.getTemp()+"</td>");
				 response.getWriter().println("<td>"+tempDTO.getDeviceId()+"</td>");
					response.getWriter().println("</tr>");
				}
				response.getWriter().println("</table>");
				response.getWriter().print("</html>");
				
				
				
				}
				catch (Exception e) {
					System.out.println(e);
				}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
