package com.playlist.domain.service;

import com.playlist.api.exceptions.EntityBadRequestException;
import com.playlist.domain.dto.AddMusicToPlayListDto;
import com.playlist.domain.dto.MusicDto;
import com.playlist.domain.dto.PlaylistDto;
import com.playlist.domain.dto.ReturnMusicToPlaylistDto;
import com.playlist.domain.model.Music;
import com.playlist.domain.model.Playlist;
import com.playlist.domain.model.User;
import com.playlist.domain.repository.MusicRepository;
import com.playlist.domain.repository.PlaylistRepository;
import com.playlist.domain.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MusicRepository musicRepository;

    public List<PlaylistDto> list() {
        List<PlaylistDto> playlistDtos = new ArrayList<>();
        for (Playlist playlist : playlistRepository.findAll()) {
            PlaylistDto dto = new PlaylistDto(playlist);
            playlistDtos.add(dto);
        }
        return playlistDtos;
    }

    public PlaylistDto findById(Integer id) {
        Playlist playlist = playlistRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        " Não existe playlist como código " + id));

        PlaylistDto playlistDto = new PlaylistDto(playlist);

        return playlistDto;

    }

    public List<PlaylistDto> listPlaylistByUser(Integer id) {

        List<PlaylistDto> playlistDtos = new ArrayList<>();

        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(
                        " Não existe o usuário com o código " + id));
        for (Playlist playlist : user.getPlaylists()) {

            PlaylistDto dto = new PlaylistDto(playlist);
            playlistDtos.add(dto);
        }

        return playlistDtos;
    }

    public PlaylistDto create(Playlist playlist) {
        playlistRepository.save(playlist);
        PlaylistDto playlistDto = new PlaylistDto(playlist);

        return playlistDto;
    }

    public ReturnMusicToPlaylistDto addMusicOnPlaylist(AddMusicToPlayListDto addMusicToPlayListDto) {

        Music music = musicRepository.findById(addMusicToPlayListDto.getMusicId()).orElseThrow(
                () -> new EntityBadRequestException(
                        " Não existe música com o código " + addMusicToPlayListDto.getMusicId()));

        Playlist playlist = playlistRepository.findById(addMusicToPlayListDto.getPlaylistId()).orElseThrow(
                () -> new EntityBadRequestException(
                        " Não existe playlist como código " + addMusicToPlayListDto.getPlaylistId()));

        if (playlist.getMusics().contains(music)) {
            throw new DataIntegrityViolationException(
                    " A música com o código " + music.getId() + " já existe na playlist ");
        }

        playlist.getMusics().add(music);

        playlistRepository.save(playlist);

        PlaylistDto playlistDto = new PlaylistDto(playlist);
        MusicDto musicDto = new MusicDto(music);

        ReturnMusicToPlaylistDto returnMusicPlaylistDto = new ReturnMusicToPlaylistDto(playlistDto, musicDto);

        return returnMusicPlaylistDto;
    }

    public PlaylistDto update(Playlist playlist) {

        Playlist playlistSave = playlistRepository.findById(playlist.getId()).
                orElseThrow(() -> new EntityNotFoundException(
                "Nao existe uma playlist com o código " + playlist.getId()));

        playlistSave.setId(playlist.getId());
        playlistSave.setName(playlist.getName());
        playlistRepository.save(playlistSave);
        
        PlaylistDto playlistDto = new PlaylistDto(playlistSave);
        
        return playlistDto;
    }

    public void delete(Integer id) {

        try {
            playlistRepository.deleteById(id);

        } catch (EmptyResultDataAccessException er) {

            throw new EntityNotFoundException(("Não existe playlist com o código %d " + id));

        } catch (DataIntegrityViolationException di) {

            throw new DataIntegrityViolationException("A entidade não poder ser excluída, pois está em uso");
        }

    }

}
