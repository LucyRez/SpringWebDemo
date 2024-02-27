package cs.hse.springWebDemo.features.songs.services

import cs.hse.springWebDemo.features.songs.dto.AlbumDto
import cs.hse.springWebDemo.features.songs.dto.SongDto
import cs.hse.springWebDemo.features.songs.repositories.AlbumRepository
import org.springframework.stereotype.Service

@Service
class AlbumService(private val albumRepository: AlbumRepository) {

    fun retrieveSongs() = albumRepository.getAllSongs()
    fun retrieveAlbums() = albumRepository.getAllAlbums()

    fun retrieveSongById(id: String) = albumRepository.getAllSongs().find {
        it.id == id
    }

    fun retrieveAlbumById(id: String) = albumRepository.getAllAlbums().find {
        it.id == id
    }

    fun tryAddSong(songDto: SongDto): String {
        if (albumRepository.addSong(songDto) == AlbumRepository.Status.SUCCESS) {
            return "Song $songDto was successfully added"
        }

        return "ERROR: Album for this song does not exist"
    }

    fun tryAddAlbum(albumDto: AlbumDto): String {
        if (albumRepository.addAlbum(albumDto) == AlbumRepository.Status.SUCCESS) {
            return "Album $albumDto was successfully added"
        }

        return "ERROR: This album already exists"
    }


}