package com.generation.javdventures.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.dto.guild.GuildDtoBase;
import com.generation.jadventures.model.dto.guild.GuildDtoWQuest;
import com.generation.jadventures.model.repositories.GuildRepository;
import com.generation.jadventures.model.service.GuildConverter;

@RestController
@CrossOrigin
 //Un commentio2
public class GuildController {
    @Autowired
    GuildRepository repo;
    @Autowired
    GuildConverter conv;
   
    @GetMapping("/guilds")
    public List<Guild> getAll() 
    {
        return repo.findAll();
    }

    @GetMapping("/guilds/{id}")
    public GuildDtoBase getOne(@PathVariable Integer id)
    {
        Optional<Guild> op = repo.findById(id);

        if(op.isEmpty())
            return null;

        return conv.guildToDtoR(op.get());
    }


    @GetMapping("/guilds/{id}/quest")
    public GuildDtoWQuest getOneWithQuest(@PathVariable Integer id)
    {
        Optional<Guild> op = repo.findById(id);

        if(op.isEmpty())
            return null;

        return conv.guildToDtoWQuest(op.get()); 
    }

}
