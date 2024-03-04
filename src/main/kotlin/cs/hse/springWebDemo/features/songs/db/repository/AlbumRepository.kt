package cs.hse.springWebDemo.features.songs.db.repository

import cs.hse.springWebDemo.features.songs.db.entities.Album
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AlbumRepository: JpaRepository<Album, Long> {
    fun findAllByArtist(artist: String): List<Album>
}


