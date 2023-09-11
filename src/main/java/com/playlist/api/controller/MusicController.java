package com.playlist.api.controller;

import com.playlist.domain.dto.MusicDto;
import com.playlist.domain.model.Music;
import com.playlist.domain.service.MusicService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/musics")
public class MusicController {

    @Autowired
    private MusicService musicService;

    @GetMapping
    public List<MusicDto> musics() {
        return musicService.list();
    }

    @GetMapping("/byplaylist/{id}")
    public List<Music> musicByPlaylist(@PathVariable Integer id) {
        return musicService.listMusicByPlaylist(id);
    }

    @GetMapping("/{id}")
    public Music findById(@PathVariable Integer id) {
        return musicService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicDto create(@RequestBody Music music) {
        return musicService.create(music);

    }

    @PutMapping
    public Music update(@RequestBody Music music) {
        return musicService.update(music);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        musicService.delete(id);
    }

}
