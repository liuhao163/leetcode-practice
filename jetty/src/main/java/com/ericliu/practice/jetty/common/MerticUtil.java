package com.ericliu.practice.jetty.common;

import com.codahale.metrics.Gauge;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.health.HealthCheckRegistry;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class MerticUtil {
    public static MetricRegistry metricRegistry = new MetricRegistry();
    public static Meter reqeust = metricRegistry.meter("request");
    public static final HealthCheckRegistry healthChecks = new HealthCheckRegistry();

    public static <T> void registerGuage(Class clz, Gauge<T> guage, String... name) {
        metricRegistry.register(MetricRegistry.name(clz, name), guage);
    }
}
