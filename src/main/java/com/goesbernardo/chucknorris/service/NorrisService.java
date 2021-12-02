package com.goesbernardo.chucknorris.service;

import com.goesbernardo.chucknorris.dto.NorrisDto;
import com.goesbernardo.chucknorris.mapper.NorrisMapper;
import com.goesbernardo.chucknorris.model.Norris;
import com.goesbernardo.chucknorris.repository.NorrisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;

@Service
public class NorrisService {

    @Autowired
    private NorrisRepository norrisRepository;

    RestTemplate restTemplate = new RestTemplate();

    private final static NorrisMapper norrisMapper = NorrisMapper.INSTANCE;

    private final static String baseUrl = "https://api.chucknorris.io/jokes/random";

    public NorrisDto findNorris(NorrisDto norrisDto) throws URISyntaxException {

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        URI uri;
        uri = new URI(baseUrl);
        ResponseEntity<NorrisDto> response = restTemplate.exchange(uri, HttpMethod.GET,entity,NorrisDto.class);

        norrisDto = response.getBody();

        Norris norrisCreated = norrisMapper.toModel(norrisDto);
        Norris createdNorris = norrisRepository.save(norrisCreated);

        return norrisDto;





    }


}
