package cs.hse.springWebDemo.features.songs.db.entities

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Entity
@Table(name = "songs")
data class Song(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    val title: String,

    @Column(name = "album_id", insertable = false, updatable = false)
    var albumId: Long,

    @ManyToOne
    @JoinColumn(name = "album_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    var album: Album? = null

)


