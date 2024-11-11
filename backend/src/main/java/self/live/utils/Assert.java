package self.live.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import self.live.exception.LiveException;

import java.util.Map;
import java.util.Objects;

public class Assert {
    public Assert() {
    }
    public static void isNotBlank(@Nullable String str, String strName) {
        if (StringUtils.isEmpty(str)) {
            throw new LiveException("[" + strName + "] Info Item cannot be blank");
        }
    }

    public static void isNotNull(@Nullable Object obj, String name) {
        if (Objects.isNull(obj)) {
            throw new LiveException("[" + name + "] Info Item cannot be null");
        }
    }

    public static void isNotEmpty(@Nullable Map map, String name) {
        if(map == null || map.isEmpty()){
            throw new LiveException("[" + name + "] Info Item cannot be empty");
        }
    }
}
