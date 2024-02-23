package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.dto.guild.GuildDtoR;
import com.generation.jadventures.model.dto.guild.GuildDtoWNoQuest;
import com.generation.jadventures.model.dto.guild.GuildDtoWQuest;
import com.generation.jadventures.model.repositories.GuildRepository;

public class GuildConverter 
{
    @Autowired
    GuildRepository gRepo;

    public Guild DtoRToGuild (GuildDtoR dto)
    {
        return  Guild
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .n_employees(dto.getN_employees())
                .hq_address(dto.getHq_address())
                .build();
    }

    public GuildDtoWNoQuest guildToDtoWNoQuest (Guild g)
    {
        return  GuildDtoWNoQuest
                .builder()
                .id(g.getId())
                .name(g.getName())
                .authentication_seal(g.getAuthentication_seal())
                .seal_img_url(g.getSeal_img_url())
                .n_employees(g.getN_employees())
                .hq_address(g.getHq_address())
                .build();
    }

    public GuildDtoWQuest guildToDtoWQuest (Guild g)
    {
        return  GuildDtoWQuest
                .builder()
                .id(g.getId())
                .name((g.getName()))
                .authentication_seal(g.getAuthentication_seal())
                .seal_img_url(g.getSeal_img_url())
                .n_employees(g.getN_employees())
                .hq_address(g.getHq_address())
                .posted_quests(g.getPosted_quests())
                .build();
    }
}
