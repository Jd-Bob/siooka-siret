package com.siooka.siret.controller;

import com.siooka.siret.common.config.ExternalConfiguration;
import com.siooka.siret.data.data_transfert_object.ResponseDto;
import com.siooka.siret.data.data_transfert_object.SiretDetailsDto;
import com.siooka.siret.data.domain_object.Etablissement;
import com.siooka.siret.service.metier.SiretServiceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/api")
public class SiretController {

    @Autowired
    ExternalConfiguration dataConfig;

    @Autowired
    SiretServiceMetier siretBusinessService;

    @GetMapping(path = "/siret/{id}")
    public ResponseEntity<SiretDetailsDto> getSiretDetails(@RequestHeader("Authorization") String token, @PathVariable String id) {
        SiretDetailsDto siret = siretBusinessService.getSiretDetails(token.substring(7), id);
        if (siret != null) {
            return ResponseEntity.ok(siret);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/sirets")
    public ResponseEntity<ResponseDto<List<Etablissement>>> getAll() {
        List<Etablissement> all = siretBusinessService.getAll();
        ResponseDto res = new ResponseDto<>();
        res.setStatus(HttpStatus.OK);
        res.setData(all);
        return ResponseEntity.ok(res);
    }
}
