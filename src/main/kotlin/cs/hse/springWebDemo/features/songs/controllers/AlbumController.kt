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
    fun getAlbumWithId(@PathVariable id: String) : ResponseEntity<AlbumDto> {
        val album = albumService.retrieveAlbumById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(album)
    }

    @PostMapping("/add")
    fun postAnAlbum(@RequestBody album: AlbumDto) : ResponseEntity<String> {
        val resp = albumService.tryAddAlbum(album)
        if (resp.contains("ERROR")) {
            return ResponseEntity.badRequest().body(resp)
        }

        return ResponseEntity.ok(resp)
    }
}