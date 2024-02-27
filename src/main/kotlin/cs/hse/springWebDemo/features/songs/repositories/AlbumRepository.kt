package cs.hse.springWebDemo.features.songs.repositories

import cs.hse.springWebDemo.features.songs.dto.AlbumDto
import cs.hse.springWebDemo.features.songs.dto.SongDto
import org.springframework.stereotype.Repository


@Repository
class AlbumRepository {

    private val albums: MutableList<AlbumDto> = mutableListOf(
        AlbumDto("1", "Блэкаут", "https://images.genius.com/c3a120256bfd8d380df0a38e238b11c4.1000x1000x1.jpg",
            "Операция пластилин"),
        AlbumDto("2", "Scaled and Icy",  "URL2", ""),
        AlbumDto("3", "Punisher", "URL3", ""),
        AlbumDto("4", "Innuendo", "URL4", "Queen")
    )

    private val songs: MutableList<SongDto> = mutableListOf(
        SongDto("1", "These Are The Days Of Our lives", "4"),
        SongDto("2", "Garden Song", "3"),
        SongDto("3", "Formidable", "2"),
        SongDto("4", "Хоровод", "1")
    )

    enum class Status {
        ERROR,
        SUCCESS
    }

    fun getAllAlbums() = albums

    fun getAllSongs() = songs

    fun addSong(song: SongDto): Status {
        if (albums.none { it.id == song.albumId }) {
            return Status.ERROR
        }

        songs.add(song)
        return Status.SUCCESS
    }

    fun addAlbum(album: AlbumDto): Status {
        if (albums.none { it.id == album.id }) {
            albums.add(album)
            return Status.SUCCESS
        }

        return Status.ERROR
    }


}