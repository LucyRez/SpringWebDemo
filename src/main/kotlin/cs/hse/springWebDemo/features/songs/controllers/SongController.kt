package cs.hse.springWebDemo.features.songs.controllers

import cs.hse.springWebDemo.features.songs.dto.SongDto
import cs.hse.springWebDemo.features.songs.services.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.Exception

@RestController
@RequestMapping("/music/songs")
class SongController(val songService: SongService) {

    @GetMapping
    fun getAllSongs() : ResponseEntity<List<SongDto>> {
        return ResponseEntity.ok(songService.retrieveSongs())
    }

    @GetMapping("/get/{id}")
    fun getSongWithId(@PathVariable("id") id: Long) : ResponseEntity<SongDto> {
        val song = songService.retrieveSongById(id) ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(song.get())
    }

    @GetMapping("/get")
    fun getSongByArtist(@RequestParam title: String) : ResponseEntity<SongDto> {
        val song = songService.retrieveSongByTitle(title).first()
        return ResponseEntity.ok(song)
    }

    @PostMapping("/add")
    fun postASong(@RequestBody song: SongDto) : ResponseEntity<String> {
        return try {
            val resp = songService.tryAddSong(song)
            ResponseEntity.ok(resp.toString())
        } catch (e: Exception) {
            ResponseEntity.badRequest().build()
        }

    }
}