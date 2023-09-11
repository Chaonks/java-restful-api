package com.playlist.domain.dto;

import com.playlist.domain.model.Music;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MusicDto {

    private Integer id;
    private String name;

    public MusicDto() {
    }

    public MusicDto(Music music) {
        this.id = music.getId();
        this.name = music.getName();
        
    }

}
