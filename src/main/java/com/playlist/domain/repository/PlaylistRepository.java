
package com.playlist.domain.repository;

import com.playlist.domain.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

}
