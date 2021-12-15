import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Results {
    final private double x;
    final private double y;
    final private double r;
    final private boolean isInArea;
    final private Date creationDate;
    final private boolean isError;
    final private String message;
}