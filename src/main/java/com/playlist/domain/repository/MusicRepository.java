
package com.playlist.domain.repository;

import com.playlist.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MusicRepository extends JpaRepository<Music, Integer>{

}
