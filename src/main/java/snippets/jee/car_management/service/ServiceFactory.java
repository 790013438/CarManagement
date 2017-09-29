package snippets.jee.car_management.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFactory {

    private static Map<Class<?>, Object> map = new HashMap<>();

    @Autowired
    private InfoService infoService;

    private ServiceFactory() {
        map.put(InfoService.class, infoService);
    }

    /**
     * 创建业务对象的工厂方法
     * @param type 业务对象的类型
     * @return 业务对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T create(Class<?> type) {
        return (T) map.get(type);
    }

}
