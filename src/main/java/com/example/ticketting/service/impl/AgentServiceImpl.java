package com.example.ticketting.service.impl;

import com.example.ticketting.feign.InquiryFeign;
import com.example.ticketting.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {

    private final InquiryFeign inquiryFeign;

    @Override
    public void callExternalService() {
        inquiryFeign.callExternal();
    }
}
