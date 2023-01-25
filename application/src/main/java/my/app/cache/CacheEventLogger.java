package my.app.cache;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Pargev 04.12.2022
 */
public class CacheEventLogger implements CacheEventListener<Object, Object> {

    private final Logger logger = LoggerFactory.getLogger(CacheEventLogger.class);

    @Override
    public void onEvent(CacheEvent<?, ?> cacheEvent) {
        logger.info(cacheEvent.getKey().toString());
    }
}
