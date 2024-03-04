package cs.hse.springWebDemo.features.songs.db.repository

import cs.hse.springWebDemo.features.songs.db.entities.Song
import cs.hse.springWebDemo.features.songs.dto.SongDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository: JpaRepository<Song, Long> {
    fun findAllByTitle(title: String): MutableList<SongDto>


}