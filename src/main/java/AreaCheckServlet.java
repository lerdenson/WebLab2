import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@MultipartConfig
@WebServlet(name = "areaCheckServlet", value = "/area-check-servlet")
public class AreaCheckServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Area Checker ready!";
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/plain");

        HttpSession session = req.getSession();
        String X = req.getParameter("X");
        String Y = req.getParameter("Y");
        String R = req.getParameter("R");

        PrintWriter out = resp.getWriter();

        ArrayList<Results> list = new ArrayList<>();

        Results results = new Results(
                Double.parseDouble(X),
                Double.parseDouble(Y),
                Double.parseDouble(R),
                isInArea(Double.parseDouble(X),
                        Double.parseDouble(Y),
                        Double.parseDouble(R)
                ),
                new Date(),
                false,
                ""
        );

        ((ArrayList<Results>)session.getAttribute("Collection")).add(results);
        list.add(results);


        out.println(JSONParser.toJSON(list));

    }

    private boolean isInArea(double x, double y, double r) {
        return isInCircle(x, y, r) || isInRectangle(x, y, r) || isInTriangle(x, y, r);
    }

    private boolean isInTriangle(double x, double y, double r) {
        return (x>= -r/2) && (x<=0) && (y<= r) && (x >= (y - r)/2);
    }

    private boolean isInCircle(double x, double y, double r) {
        return (x*x + y*y <= r*r) && (x<=0) && (y<=0);
    }

    private boolean isInRectangle(double x, double y, double r) {
        return (x >= 0) && (x <= r/2) && (y <= 0) && (y >= -r);
    }

    public void destroy() {
    }
}