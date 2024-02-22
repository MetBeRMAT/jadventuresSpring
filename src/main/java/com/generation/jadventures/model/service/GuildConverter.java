package com.generation.jadventures.model.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.model.dto.guild.GuildDtoBase;
import com.generation.jadventures.model.dto.guild.GuildDtoR;
import com.generation.jadventures.model.repositories.GuildRepository;

public class GuildConverter 
{
    @Autowired
    GuildRepository gRepo;

    public GuildDtoBase guildToDtoBase (Guild g)
    {
        return GuildDtoBase
               .builder()
               .name(g.getName())
               .authentication_seal(g.getAuthentication_seal())
               .seal_img_url(g.getSeal_img_url())
               .n_employees(g.getN_employees())
               .hq_address(g.getHq_address())
               .build();
    }


    public GuildDtoR guildToDtoR ( Guild g)
    {
        return GuildDtoR
               .builder()
               .id(g.getId())
               .authentication_seal(g.getAuthentication_seal())
               .seal_img_url(g.getSeal_img_url())
               .n_employees(g.getN_employees())
               .hq_address(g.getHq_address())
               .build();
    }

}
