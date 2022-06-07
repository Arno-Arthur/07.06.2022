package com.arno.rest.controller;


import com.arno.domain.User;
import com.arno.rest.dto.CallDto;
import com.arno.rest.dto.MedicationsDto;
import com.arno.rest.dto.TokenDto;
import com.arno.service.CallService;
import com.arno.service.TokenService;
import com.arno.service.TokenServiceImpl;
import com.arno.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor

public class CallController {

    private CallService callService;
    private TokenService tokenService;

    @PostMapping("/call")
    public List<CallDto> getAllCalls(@RequestBody TokenDto tokenDto){
        Integer id = tokenService.getUserIdByToken(tokenDto.getValue());
        if (id == null) {
            return Collections.emptyList();
        }
        return callService.getForUser(id).stream().map(CallDto::toDto).collect(Collectors.toList());
    }
}
