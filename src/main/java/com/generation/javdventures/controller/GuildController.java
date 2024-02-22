package com.generation.javdventures.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.repositories.GuildRepository;

@RestController
@CrossOrigin

public class GuildController {
    @Autowired
    GuildRepository repo;
    @Autowired
    GuildConverter conv;

    @GetMapping("/guild")
    public List<Guild> getAll() {
        return repo.findAll();
    }

    @GetMapping("/guild/{id}")
    public GuildWNoQuest getOne(@PathVariable Integer id)
    {
        Optional<Guild> op = repo.findById(id);

        if(op.isEmpty())
            return null;

            return conv.GuildWNoQuest(op.get());
    }

    @GetMapping("/guild/{id}/quest")
    public GuildDtoWQuest getOneWithQuest(@PathVariable Integer id)
    {
        Optional<Guild> op = repo.findById(id);

        if(op.isEmpty())
            return null;

            return conv.guildWQuest(op.get()); 
    }

}
