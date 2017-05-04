import java.util.Arrays;
import java.util.List;

public class DarkSoulsMaster {
    public final boolean devmode;

    public DarkSoulsMaster() {
        this.devmode = false;
    }

    public DarkSoulsMaster(boolean devmode) {
        this.devmode = devmode;
    }

    public static void main(String[] args) {
        List<String> argsList = Arrays.asList(args);
        DarkSoulsMaster master = new DarkSoulsMaster(argsList.contains("devmode"));
        System.out.println(master.devmode);
    }
}
