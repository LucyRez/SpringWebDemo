package cs.hse.springWebDemo.features.songs.services

import cs.hse.springWebDemo.features.songs.db.entities.Album
import cs.hse.springWebDemo.features.songs.dto.AlbumDto
import cs.hse.springWebDemo.features.songs.dto.SongDto
import cs.hse.springWebDemo.features.songs.db.repository.AlbumRepository
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class AlbumService(private val albumRepository: AlbumRepository) {

    fun retrieveAlbums() = albumRepository.findAll().map { it ->
        AlbumDto(it.title, it.imageUrl, it.artist, it.songs.map {
            SongDto(it.title, it.albumId)
        }.toMutableList())
    }.toList()

    fun retrieveAlbumById(id: Long): AlbumDto = albumRepository.findById(id).map { it ->
        AlbumDto(it.title, it.imageUrl, it.artist, it.songs.map {
            SongDto(it.title, it.albumId)
        }.toMutableList())
    }.orElseThrow()

    fun retrieveAlbumsByArtist(artist: String): List<AlbumDto> = albumRepository.findAllByArtist(artist)
        .map { it ->
            AlbumDto(it.title, it.imageUrl, artist, it.songs.map {
                SongDto(it.title, it.albumId)
            }.toMutableList())
        }.toList()


    fun tryAddAlbum(albumDto: AlbumDto) =
        albumRepository.save(Album(title = albumDto.title, artist = albumDto.artist, imageUrl = albumDto.imageUrl)).id

}