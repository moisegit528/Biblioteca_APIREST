package com.moisegit.to_do_list.controller;

import com.moisegit.to_do_list.dto.LeitorDto;
import com.moisegit.to_do_list.model.LeitorEntity;
import com.moisegit.to_do_list.service.LeitorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leitor")
@RequiredArgsConstructor
public class LeitorController {

    private final LeitorService leitorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastroLeitor(@RequestBody LeitorDto leitorDto) {
        leitorService.cadastroLeitor(leitorDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<LeitorEntity> readerList() {
        return leitorService.readerList();
    }
    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LeitorEntity findByid(@PathVariable Integer id) {
        return leitorService.findByid(id);
    }
    @GetMapping("/email/{email}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public LeitorEntity findByEmail(@PathVariable String email) {
        return leitorService.findByEmail(email);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateData(@PathVariable Integer id, @RequestBody LeitorDto leitorDto) {
        leitorService.updateData(id, leitorDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReader(@PathVariable Integer id) {
        leitorService.deleteReader(id);
    }

}
