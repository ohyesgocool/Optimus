package utils;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Iterator;
import java.util.Map;

public class SetCapability {

    public DesiredCapabilities mapCapability(Map<String, String> map , DesiredCapabilities capabilities){


        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
        }
        return capabilities;


    }
}
