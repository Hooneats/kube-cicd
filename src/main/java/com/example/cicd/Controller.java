package com.example.cicd;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class Controller {

    @GetMapping
    public String  home(final HttpServletRequest request) {
        final var ip = request.getHeader("X-FORWARDED-FOR") == null ?
                request.getRemoteAddr() :
                request.getHeader("X-FORWARDED-FOR");
        final var sb = new StringBuilder();
        sb.append("당신");
        if (request.getRemoteUser() != null)
            sb.append(request.getRemoteUser()).append("님");
        sb.append("의 아이피는 ")
                .append(ip)
                .append("입니다.");

        return sb.toString();
    }

}
