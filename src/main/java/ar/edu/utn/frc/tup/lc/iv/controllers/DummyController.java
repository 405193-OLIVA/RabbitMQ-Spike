package ar.edu.utn.frc.tup.lc.iv.controllers;

import ar.edu.utn.frc.tup.lc.iv.dtos.DummyDto;
import ar.edu.utn.frc.tup.lc.iv.models.Dummy;
import ar.edu.utn.frc.tup.lc.iv.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping
    public ResponseEntity<DummyDto> getDummyList(){
        List<Dummy> dummyList = dummyService.getDummyList();
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DummyDto> getDummy(@PathVariable Long id){
        Dummy dummy = dummyService.getDummy(id);
        return null;
    }

    @PostMapping
    public ResponseEntity<DummyDto> createDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.createDummy(null);
        return null;
    }

    @PutMapping
    public ResponseEntity<DummyDto> updateDummy(DummyDto dummyDto){
        Dummy dummy = dummyService.updateDummy(null);
        return null;
    }

    @DeleteMapping
    public ResponseEntity<DummyDto> deleteDummy(DummyDto dummyDto){
        dummyService.deleteDummy(null);
        return null;
    }
}
