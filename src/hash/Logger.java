package hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajat on 6/18/16.
 */
public class Logger {

    Map<String, Integer> logHash;

    /**
     * Initialize your data structure here.
     */
    public Logger() {
        logHash = new HashMap<>();
    }

    /**
     * Returns true if the message should be printed in the given timestamp, otherwise returns false.
     * If this method returns false, the message will not be printed.
     * The timestamp is in seconds granularity.
     */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (logHash.containsKey(message) && timestamp - logHash.get(message) > 10) {
            logHash.put(message, timestamp);
            return true;
        } else if (!logHash.containsKey(message)) {
            logHash.put(message, timestamp);
            return true;
        } else {
            return false;
        }
    }


}
