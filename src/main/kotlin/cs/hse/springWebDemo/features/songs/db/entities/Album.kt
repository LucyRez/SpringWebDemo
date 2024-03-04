package cs.hse.springWebDemo.features.songs.db.entities

import jakarta.persistence.*
import lombok.NoArgsConstructor

@Entity
@Table(name = "album")
@NoArgsConstructor
data class Album(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val title: String,
    val artist: String,

    @Column(name="image_url")
    val imageUrl: String,

    @OneToMany(mappedBy = "albumId", fetch = FetchType.LAZY)
    var songs: MutableList<Song> = mutableListOf<Song>()
)
