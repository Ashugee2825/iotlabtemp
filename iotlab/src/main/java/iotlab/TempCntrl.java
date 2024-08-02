package iotlab;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class TempCntrl
 */
@WebServlet("/TempCntrl")
public class TempCntrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TempCntrl() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String deviceId = request.getParameter("deviceId");
		String temp = request.getParameter("temp");
		
		//convert raw values to Object
		
		TempDTO tempDTO = new TempDTO();
		
		tempDTO.setDeviceId(deviceId);
		tempDTO.setTemp(temp);
		
		tempDTO.display();
		
		//CONVERT STRING TO FLOATING POINT VALUE OR DECIMAL POINT VALUE
		float tempValue=0.0f;
		String signal="";
		try {
		tempValue = Float.parseFloat(tempDTO.getTemp());
		}
		catch (Exception e) {
			
			System.out.println("Exception thrown");
		}
		
				
		
		if(tempValue<=35.00)
			signal="g";
		else if(tempValue>35.00 && tempValue<=49.00 )
			signal="y";
		else if(tempValue>35.00 && tempValue<=49.00 )
		signal="r";
		
		response.getWriter().print(signal);
		
		
		System.out.println("Response for device Id "+tempDTO.getDeviceId()+" is "+signal);
		
		//add temperature sent by temp sensors to the list
		ServletContext ctx = getServletContext();
		try {
		ArrayList<TempDTO> list = (ArrayList<TempDTO>)ctx.getAttribute("tempList");
		
		list.add(tempDTO);
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
