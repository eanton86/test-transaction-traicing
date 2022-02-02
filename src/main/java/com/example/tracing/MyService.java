package com.example.tracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Autowired
    private Tracer tracer;

    @NewSpan
    public String getTraceWithNewSpan() {
        return tracer.currentTraceContext().context().traceId();
    }

    @Transactional
    public String getTraceWithTransactional() {
        return tracer.currentTraceContext().context().traceId();
    }
}
