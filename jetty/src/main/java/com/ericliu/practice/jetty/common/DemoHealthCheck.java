package com.ericliu.practice.jetty.common;

import com.codahale.metrics.health.HealthCheck;

import java.util.Map;
import java.util.concurrent.*;

import static com.ericliu.practice.jetty.common.MerticUtil.healthChecks;

/**
 * @Author: liuhaoeric
 * Create time: 2019/11/06
 * Description:
 */
public class DemoHealthCheck extends HealthCheck {

    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public DemoHealthCheck() {
        executor.scheduleAtFixedRate(() -> {
            final Map<String, Result> results = healthChecks.runHealthChecks();
            for (Map.Entry<String, Result> entry : results.entrySet()) {
                if (entry.getValue().isHealthy()) {
                    System.out.println(entry.getKey() + " is healthy");
                } else {
                    System.err.println(entry.getKey() + " is UNHEALTHY: " + entry.getValue().getMessage());
                    final Throwable e = entry.getValue().getError();
                    if (e != null) {
                        e.printStackTrace();
                    }
                }
            }
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void register(){
        healthChecks.register("mysql", this);
    }

    @Override
    protected Result check() throws Exception {
        //todo 校验
        if (System.currentTimeMillis() % 2 == 0) {
            return HealthCheck.Result.healthy();
        } else {
            return HealthCheck.Result.unhealthy("Cannot connect to ");
        }
    }

}
