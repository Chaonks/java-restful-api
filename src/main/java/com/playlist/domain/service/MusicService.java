package com.playlist.domain.service;

import com.playlist.domain.dto.MusicDto;
import com.playlist.domain.model.Music;
import com.playlist.domain.model.Playlist;
import com.playlist.domain.repository.MusicRepository;
import com.playlist.domain.repository.PlaylistRepository;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;
    @Autowired
    private PlaylistRepository playlistRepository;

    public List<MusicDto> list() {
        List<MusicDto> musicDtos = new ArrayList<>();
        for (Music music : musicRepository.findAll()) {
            MusicDto dto = new MusicDto(music);
            musicDtos.add(dto);
        }
        return musicDtos;
    }
    
    public Music findById(Integer id) {
        Music music = musicRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        " Não existe uma músic com o código " + id));
        return music;

    }

    public MusicDto create(Music music) {

        musicRepository.save(music);
        MusicDto musicDto = new MusicDto(music);
        return musicDto;

    }

    public List<Music> listMusicByPlaylist(Integer id) {

        Playlist playlist = playlistRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        " Não existe uma playlist com o código " + id));

        List<Music> musics = playlist.getMusics();

        return musics;
    }

    public Music update(Music music) {

        findById(music.getId());

        Music musicSave = new Music();
        musicSave.setId(music.getId());
        musicSave.setName(music.getName());

        return musicRepository.save(musicSave);
    }

    public void delete(Integer id) {

        try {
            musicRepository.deleteById(id);

        } catch (EmptyResultDataAccessException er) {

            throw new EntityNotFoundException(
                    " Não existe uma música com o código " + id);

        } catch (DataIntegrityViolationException di) {

            throw new DataIntegrityViolationException(
                    "A entidade não poder ser excluída, pois está em uso");
        }
    }
}
