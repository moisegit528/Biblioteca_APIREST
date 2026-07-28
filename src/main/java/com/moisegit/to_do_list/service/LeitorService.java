package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.LeitorDto;
import com.moisegit.to_do_list.model.LeitorEntity;
import com.moisegit.to_do_list.repository.EmprestimoRepository;
import com.moisegit.to_do_list.repository.LeitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LeitorService {

    private final LeitorRepository leitorRepository;
    private final EmprestimoRepository emprestimoRepository;

    // POST - cadastro do leitor
    public void cadastroLeitor(LeitorDto leitorDto) {
        leitorRepository.save(LeitorEntity.builder()
                        .nome(leitorDto.getNome())
                        .email(leitorDto.getEmail())
                .build());
    }
    // GET - lista todos os leitores
    public List<LeitorEntity> readerList(){
        return leitorRepository.findAll();
    }
    // GET - lista leitor por Id
    public List<LeitorEntity> findByid(Integer id) {
        return leitorRepository.findByid(id);
    }
    // GET - lista leitor por Email
    public List<LeitorEntity> findByEmail(String email) {
        return leitorRepository.findByEmail(email);
    }
    // PUT - atualizar dados do leitor
    public void updateData(LeitorDto leitorDto) {

        leitorRepository.save(LeitorEntity.builder()
                        .nome(leitorDto.getNome())
                        .email(leitorDto.getEmail())
                .build());
    }
    // DELETE
    public void deleteReader(Integer id) {
        leitorRepository.deleteById(id);
    }
}
