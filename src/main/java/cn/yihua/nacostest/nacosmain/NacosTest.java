package cn.yihua.nacostest.nacosmain;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.Executor;

public class NacosTest {
    public static final String serverAddr = "localhost";
    public static final String dataId = "appA";
    public static final String group = "DEFAULT_GROUP";
    public static void main(String[] args) throws NacosException, IOException {
        Properties properties = new Properties();
        properties.put("serverAddr",serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String context = configService.getConfig(dataId,group,5000);
        System.out.println("first receive:"+context);
        configService.addListener(dataId, group, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("currentTime:"+new Date()+" receive:"+configInfo);
            }
        });
        int n = System.in.read();
    }
}
