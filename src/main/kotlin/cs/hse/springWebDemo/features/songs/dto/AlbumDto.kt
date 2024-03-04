package cs.hse.springWebDemo.features.songs.dto

data class AlbumDto (
    val title: String,
    val imageUrl: String,
    val artist: String,
    val songs: MutableList<SongDto>?
)