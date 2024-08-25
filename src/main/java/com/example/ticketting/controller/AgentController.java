package com.example.ticketting.controller;


import com.example.ticketting.model.dto.BaseResponseDTO;
import com.example.ticketting.service.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/agents")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @GetMapping
    public ResponseEntity<BaseResponseDTO> testFeign(){
        agentService.callExternalService();
        BaseResponseDTO<Object> hi = BaseResponseDTO.builder().message("hi").build();
        return ResponseEntity.ok(hi);
    }
}
