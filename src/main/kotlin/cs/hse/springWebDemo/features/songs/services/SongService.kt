package cs.hse.springWebDemo.features.songs.services

import cs.hse.springWebDemo.features.songs.db.entities.Song
import cs.hse.springWebDemo.features.songs.db.repository.AlbumRepository
import cs.hse.springWebDemo.features.songs.db.repository.SongRepository
import cs.hse.springWebDemo.features.songs.dto.SongDto
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class SongService (private val songRepository: SongRepository, private val albumRepository: AlbumRepository) {

    fun retrieveSongs() = songRepository.findAll().map {
        it -> SongDto(it.title, it.albumId)
    }

    fun retrieveSongById(id: Long): Optional<SongDto> = songRepository.findById(id).map {
        it -> SongDto(it.title, it.albumId)
    }


    fun retrieveSongByTitle(title: String) = songRepository.findAllByTitle(title)


    @Transactional
    fun tryAddSong(songDto: SongDto): String {
        val album = albumRepository.findById(songDto.albumId).orElseThrow()
        return songRepository.save(Song(title = songDto.title, albumId = songDto.albumId, album = album)).id.toString()
    }
}