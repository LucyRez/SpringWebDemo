package cs.hse.springWebDemo.features.songs.dto

import java.util.UUID

data class SongDto (
    val title: String,
    val albumId: Long
)