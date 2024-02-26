package com.generation.jadventures.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.dto.guild.GuildDtoR;
import com.generation.jadventures.model.dto.guild.GuildDtoWNoQuest;
import com.generation.jadventures.model.dto.guild.GuildDtoWQuest;
import com.generation.jadventures.model.repositories.GuildRepository;
import com.generation.jadventures.model.service.GuildConverter;

@RestController
public class GuildController 
{
    @Autowired
    GuildRepository repo;
    @Autowired
    GuildConverter conv;
   
    @GetMapping("/guilds")
    public List<GuildDtoWQuest> getAll() 
    {
        return repo.findAll().stream().map(g -> conv.guildToDtoWQuest(g)).toList();
    }

    @GetMapping("/guilds/{id}")
    public GuildDtoWNoQuest getOne(@PathVariable Integer id)
    {
        return conv.guildToDtoWNoQuest(repo.findById(id).get());
    }

    @GetMapping("/guilds/{id}/quest")
    public GuildDtoWQuest getOneWithQuest(@PathVariable Integer id)
    {
        return conv.guildToDtoWQuest(repo.findById(id).get());
    }

    @PostMapping("/guilds/{id}/quest")
    public GuildDtoWQuest UpdateWithId(@PathVariable Integer id,@RequestBody GuildDtoR dto)
    {
        Optional<Guild> optionalGuild = repo.findById(id);
        if (optionalGuild.isPresent()) 
        {
            Guild guild = optionalGuild.get();
            
            Guild updatedGuild = conv.DtoRToGuild(dto);
            
            guild.setName(updatedGuild.getName());
            guild.setN_employees(updatedGuild.getN_employees());
            guild.setHq_address(updatedGuild.getHq_address());
            
            repo.save(guild);
            
            return conv.guildToDtoWQuest(updatedGuild);
        } 
        else 
            return null;
    }
    

}