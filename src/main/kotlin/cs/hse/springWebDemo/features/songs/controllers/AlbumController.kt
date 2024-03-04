package cs.hse.springWebDemo.features.songs.controllers

import cs.hse.springWebDemo.features.songs.dto.AlbumDto
import cs.hse.springWebDemo.features.songs.services.AlbumService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/music/albums")
class AlbumController (private val albumService: AlbumService) {

    @GetMapping
    fun getAllAlbums() : ResponseEntity<List<AlbumDto>> {
        return ResponseEntity.ok(albumService.retrieveAlbums())
    }

    @GetMapping("/get/{id}")
    fun getAlbumWithId(@PathVariable id: Long) : ResponseEntity<AlbumDto> {
        val album = albumService.retrieveAlbumById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(album)
    }

    @GetMapping("/get")
    fun getAlbumsByArtist(@RequestParam artist: String) : ResponseEntity<List<AlbumDto>> {
        val albums = albumService.retrieveAlbumsByArtist(artist)
        return ResponseEntity.ok(albums)
    }

    @PostMapping("/add")
    fun postAnAlbum(@RequestBody album: AlbumDto) : ResponseEntity<String> {
        val resp = albumService.tryAddAlbum(album) ?: return ResponseEntity.badRequest().build()
        return ResponseEntity.ok(resp.toString())
    }
}