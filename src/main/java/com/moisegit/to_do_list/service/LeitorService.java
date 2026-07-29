package com.moisegit.to_do_list.service;

import com.moisegit.to_do_list.dto.LeitorDto;
import com.moisegit.to_do_list.exception.NotFoundException;
import com.moisegit.to_do_list.model.LeitorEntity;
import com.moisegit.to_do_list.repository.EmprestimoRepository;
import com.moisegit.to_do_list.repository.LeitorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public LeitorEntity findByid(Integer id) throws NotFoundException {
        return leitorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado"));
    }
    // GET - lista leitor por Email
    public LeitorEntity findByEmail(String email) throws NotFoundException {
        return leitorRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado"));
    }
    // PUT - atualizar dados do leitor
    public LeitorDto updateData(Integer id, LeitorDto leitorDto) throws NotFoundException {
        LeitorEntity leitor = leitorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Leitor não encontrado!"));
            leitor.setNome(leitorDto.getNome());
            leitor.setEmail(leitorDto.getEmail());
            LeitorEntity leitorAtualizado = leitorRepository.save(leitor);
            return LeitorDto.builder()
                    .nome(leitorAtualizado.getNome())
                    .email(leitorAtualizado.getEmail())
                    .build();
    }
    // DELETE
    public void deleteReader(Integer id) {
        leitorRepository.deleteById(id);
    }
}
