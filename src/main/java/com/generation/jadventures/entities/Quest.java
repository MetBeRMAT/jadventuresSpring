package com.generation.jadventures.entities;

import java.time.LocalDate;
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


public class Quest 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date_created;
    private String status;
    private String rank;
    private int reward;
    private String area;
    private LocalDate date_completed;
    private String map_url;
    private String description;
    private String type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "guild_id")
    private Guild patron;

    @JsonIgnore
    @OneToMany(mappedBy = "party_id", fetch = FetchType.EAGER)
    private Party questOfParty;

    




}
