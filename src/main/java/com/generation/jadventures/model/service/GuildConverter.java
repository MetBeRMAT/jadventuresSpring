package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.dto.guild.GuildDtoBase;
import com.generation.jadventures.model.dto.guild.GuildDtoR;
import com.generation.jadventures.model.dto.guild.GuildDtoWQuest;
import com.generation.jadventures.model.repositories.GuildRepository;

public class GuildConverter 
{
    @Autowired
    GuildRepository gRepo;

    public GuildDtoBase guildToDtoBase (Guild g)
    {
        return  GuildDtoBase
                .builder()
                .name(g.getName())
                .authentication_seal(g.getAuthentication_seal())
                .seal_img_url(g.getSeal_img_url())
                .n_employees(g.getN_employees())
                .hq_address(g.getHq_address())
                .build();
    }


    public GuildDtoR guildToDtoR (Guild g)
    {
        return  GuildDtoR
               .builder()
               .id(g.getId())
               .name((g.getName()))
               .authentication_seal(g.getAuthentication_seal())
               .seal_img_url(g.getSeal_img_url())
               .n_employees(g.getN_employees())
               .hq_address(g.getHq_address())
               .build();
    }

    public GuildDtoWQuest guildToDtoWQuest (Guild dto)
    {
        return  GuildDtoWQuest
                .builder()
                .id(dto.getId())
                .name((dto.getName()))
                .authentication_seal(dto.getAuthentication_seal())
                .seal_img_url(dto.getSeal_img_url())
                .n_employees(dto.getN_employees())
                .hq_address(dto.getHq_address())
                .posted_quests(dto.getPosted_quests())
                .build();
    }
    

}
