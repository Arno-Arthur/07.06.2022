package com.arno.rest.controller;

import com.arno.rest.dto.CallDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.CallService;
import com.arno.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class CallController {

    private final CallService callService;
    private final TokenService tokenService;

    @PostMapping("/calls")
    public List<CallDto> getCallsForUser(@RequestBody TokenDto tokenDto){
        Integer id = tokenService.getUserIdByToken(tokenDto.getValue());
        if (id == null) {
            return Collections.emptyList();
        }
        return callService.getForUser(id).stream().map(CallDto::toDto).collect(Collectors.toList());
    }
}
