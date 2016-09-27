package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        System.out.println("Constructor");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destory");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

//	/**
//	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("Service");
//		doGet(request, response);
//	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Get");
		
		// 기본 encoding 방식  : ISO-8859-1(서유럽어)
		// 한글 및 일어 불가 (X)
		// 변환 메소드를 사용하여 한글 지원!
		response.setCharacterEncoding("UTF-8");
		//response.setCharacterEncoding("EUC-KR");

		// MIME TYPE
		// Contente Type( Text/Html ) Mode Change
		// !Out Object 생성 전에 언급.
		response.setContentType("text/html; charset=UTF-8");

		// 서블릿에 기본 객체가 없다. (JSP에는 존재함.)
		// 기본 객체를 구현해서 사용.
		// JSP의 out 객체와 동일한 역할을 한다. 단, System.out.print()의 출력과는 다르다.
		// System.out.println : TextMode ( Console Terminal mode / Character )
		// JSP/Servlet out : GraphicMode ( Pixel Drawing / PictureText )
		PrintWriter out = response.getWriter(); 
		
		out.print("TEST"+"<br>"); // <br> Tag를 이용한 개행 가능.(Content Type "text/html"일 경우!)
		out.print("<b>"+"한글"+"</b>");
		out.print("한글 테스트<br>");

		out.print(request.getParameter("txt") + "<br>");
		out.print(request.getParameter("txt2") + "<br>");

		String strA = request.getParameter("txt");
		String strB = request.getParameter("txt2");
		
		// getBytes는 Tomcat 7 까지 적용되나 Tomcat 8 부터는 불가.
		strA = new String(strA.getBytes("ISO-8859-1"),"EUC_KR");
		strB = new String(strB.getBytes("ISO-8859-1"),"EUC_KR");
		
		out.print("strA (txt)  : " + strA + "<br>");
		out.print("strB (txt2) : " + strB + "<br>");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String strA = request.getParameter("txt");
		String strB = request.getParameter("txt2");
		out.println("txt : " + strA);
		out.println("txt : " + strB); 
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doHead(HttpServletRequest, HttpServletResponse)
	 */
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
	 */
	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doTrace(HttpServletRequest, HttpServletResponse)
	 */
	protected void doTrace(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
