package com.project.simpleB.member.controller;

import com.project.simpleB.member.dto.MemberDTO;
import com.project.simpleB.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signIn")
    public ResponseEntity<MemberDTO> signIn(@RequestBody MemberDTO memberDTO) {
        MemberDTO tmp = memberService.signIn(memberDTO);

        if (tmp == null) {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(tmp, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MemberDTO>> list() {
        List<MemberDTO> list = memberService.list();

        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
