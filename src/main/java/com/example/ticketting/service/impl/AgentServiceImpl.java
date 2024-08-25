package com.example.ticketting.service.impl;

import com.example.ticketting.feign.InquiryFeign;
import com.example.ticketting.service.AgentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AgentServiceImpl implements AgentService {

    private final InquiryFeign inquiryFeign;

    @Override
    public void callExternalService() {
        log.info("going to call feign");
        inquiryFeign.callExternal();
    }
}
