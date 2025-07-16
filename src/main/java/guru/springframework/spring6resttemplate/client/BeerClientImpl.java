package guru.springframework.spring6resttemplate.client;

import guru.springframework.spring6resttemplate.model.BeerDTOPageImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RequiredArgsConstructor
@Service
public class BeerClientImpl implements BeerClient {

    private final RestTemplateBuilder restTemplateBuilder;

    private static final String BEERS_URL = "/api/v1/beer";

    @Override
    public BeerDTOPageImpl listBeers() {

        RestTemplate restTemplate = restTemplateBuilder.build();

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath(BEERS_URL);

        ResponseEntity<BeerDTOPageImpl> response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), BeerDTOPageImpl.class);


        return response.getBody();
    }
}
