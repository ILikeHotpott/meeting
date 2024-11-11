package self.live.constant;

import org.springframework.http.HttpMethod;

public class GlobalConstant {

    public static final int ROOM_MIN_NUMBER = 2;

    public static final int ROOM_MAX_NUMBER = 6;

    public static final String[] ALLOWED_ORIGINS = {
            "http://127.0.0.1:5500",
            "http://localhost:5500",
            "http://localhost:63343",
            "http://localhost:63342"
    };
    public static final String[] ALLOWED_METHODS = {
            HttpMethod.GET.name(),
            HttpMethod.POST.name()
    };
}
