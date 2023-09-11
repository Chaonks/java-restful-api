package com.playlist.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Table(name = "playlist")
public class Playlist {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotNull
    @NotBlank
    @NotEmpty
    @Column( nullable = false)
    private String name;

    @ManyToMany(mappedBy = "playlists")
    private List<User> users;

    @ManyToMany
    List<Music> musics;
    
}
