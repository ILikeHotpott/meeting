package self.live.controller;

import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import self.live.entity.SelfConfigPropertiesBean;
import self.live.utils.Assert;
import self.live.utils.RoomInfoUtil;
import self.live.utils.SignTransferUtil;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final SelfConfigPropertiesBean selfConfigPropertiesBean;

    public AdminController(SelfConfigPropertiesBean selfConfigPropertiesBean) {
        this.selfConfigPropertiesBean = selfConfigPropertiesBean;
    }

    @GetMapping("/clear")
    public String clear(@RequestParam("plaintext") String plaintext) {
        try {
            Assert.isNotBlank(plaintext, "");
            String ciphertext = DigestUtils.md5DigestAsHex(plaintext.getBytes(StandardCharsets.UTF_8)).toUpperCase(Locale.CHINA);
            String ciphertext1 = selfConfigPropertiesBean.getCiphertext();
            if (ciphertext1.equals(ciphertext)) {
                RoomInfoUtil.clear();
                SignTransferUtil.clear();
                return "ok";
            }
        } catch (Exception e) {
            return "error";
        }
        return "error";
    }
}
