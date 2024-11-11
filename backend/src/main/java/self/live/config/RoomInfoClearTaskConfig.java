package self.live.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import self.live.utils.RoomInfoUtil;

@Configuration
@EnableScheduling
public class RoomInfoClearTaskConfig {

    @Scheduled(cron = "0 30 12 * * ?")
    public void clearTask() {
        RoomInfoUtil.clearTask();
    }
}
