package com.generation.jadventures.model.dto.quest;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class QuestDtoRpost extends QuestDtoBase
{
    public QuestDtoRpost(){}
    private Integer guild_id;
}
