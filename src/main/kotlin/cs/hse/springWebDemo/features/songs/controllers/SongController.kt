package cs.hse.springWebDemo.features.songs.controllers

import cs.hse.springWebDemo.features.songs.dto.SongDto
import cs.hse.springWebDemo.features.songs.services.AlbumService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/music/songs")
class SongController(val songService: AlbumService) {

    @GetMapping
    fun getAllSongs() : ResponseEntity<List<SongDto>> {
        return ResponseEntity.ok(songService.retrieveSongs())
    }

    @GetMapping("/get/{id}")
    fun getSongWithId(@PathVariable("id") id: String) : ResponseEntity<SongDto> {
        val song = songService.retrieveSongById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(song)
    }

    @PostMapping("/add")
    fun postASong(@RequestBody song: SongDto) : ResponseEntity<String> {
        val resp = songService.tryAddSong(song)
        if (resp.contains("ERROR")) {
            return ResponseEntity.badRequest().body(resp)
        }

        return ResponseEntity.ok(resp)
    }
}