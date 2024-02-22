package com.generation.jadventures.model.dto.quest;

import com.generation.jadventures.entities.Quest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class QuestDtoRput extends QuestDtoBase
{
    private Integer guild_id;
    private Integer id;
    public QuestDtoRput(){}
}
