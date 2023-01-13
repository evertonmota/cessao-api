package br.gov.ma.cessaoapi.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/estados", produces = MediaType.APPLICATION_JSON_VALUE)
public class EstadoController {
}
