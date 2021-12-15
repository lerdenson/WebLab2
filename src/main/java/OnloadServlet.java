import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@MultipartConfig
@WebServlet(name = "onloadServlet", value = "/onload-servlet")
public class OnloadServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Onload ready!";
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        ArrayList<Results> collection = (ArrayList<Results>) session.getAttribute("Collection");
        out.println(JSONParser.toJSON(collection));

    }

    public void destroy() {
    }
}