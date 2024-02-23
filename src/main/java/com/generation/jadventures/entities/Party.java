package com.generation.jadventures.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder


public class Party 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String authentication_seal;
    private String motto;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "party_leader")
    private Adventurer party_leader;

    @JsonIgnore
    @OneToMany(mappedBy = "questOfParty", fetch = FetchType.EAGER)
    private List<Quest> quests;

    @JsonIgnore
    @OneToMany(mappedBy = "party", fetch = FetchType.EAGER)
    private List<Adventurer> adventurers;


}
