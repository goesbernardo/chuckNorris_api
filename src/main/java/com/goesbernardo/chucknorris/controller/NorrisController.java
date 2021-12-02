package com.goesbernardo.chucknorris.controller;

import com.goesbernardo.chucknorris.dto.NorrisDto;
import com.goesbernardo.chucknorris.service.NorrisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "api/v1")
public class NorrisController {


    @Autowired
    private NorrisService norrisService;

    @GetMapping(value = "/findNorris")
    public ResponseEntity<NorrisDto> findNorris(NorrisDto norrisDto) throws URISyntaxException {

        NorrisDto norrisResponse = norrisService.findNorris(norrisDto);

        return ResponseEntity.ok().body(norrisResponse);

    }
}
