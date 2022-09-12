package cn.itcast.user.pojo;

import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.stereotype.*;

@Data
@Component
@ConfigurationProperties(prefix = "date")   //在配置属性中只要前缀为date,与实体类中的属性的组合只要能被找到，就会自动注入
public class DateProperties {
    String format;          //相当于data.format
    String message;
}
