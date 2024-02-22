package com.generation.jadventures.model.dto.quest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data

public class QuestDtoR extends QuestDtoBase
{
    public QuestDtoR(){}
    private Integer id;
    private Integer guild_id;
     
}
