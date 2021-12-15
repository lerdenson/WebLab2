import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "errorServlet", value = "/error-servlet")
public class ErrorServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Error servlet ready!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        message = (String) request.getAttribute("message");
        PrintWriter out = response.getWriter();
        ArrayList<Results> error = new ArrayList<>();
        Results errorResults = new Results(0, 0, 0, false, new Date(), true, message);
        error.add(errorResults);
        out.println(JSONParser.toJSON(error));
    }


    public void destroy() {
    }
}