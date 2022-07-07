package edu.miu.cs.cs425.mystudentmgmtwebapp.service.impl;

import edu.miu.cs.cs425.mystudentmgmtwebapp.model.Transcript;
import edu.miu.cs.cs425.mystudentmgmtwebapp.repository.TranscriptRepository;
import edu.miu.cs.cs425.mystudentmgmtwebapp.service.TranscriptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranscriptServiceImpl implements TranscriptService {

    @Autowired
    private TranscriptRepository transcriptRepository;

    @Override
    public Transcript save(Transcript t) {
        return transcriptRepository.save(t);
    }
}
