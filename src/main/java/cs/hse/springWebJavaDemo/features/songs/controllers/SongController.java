package cs.hse.springWebJavaDemo.features.songs.controllers;

import cs.hse.springWebJavaDemo.features.songs.dto.SongDto;
import cs.hse.springWebJavaDemo.features.songs.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/songs")
@RequiredArgsConstructor
class SongController {

    private final AlbumService songService;
    @GetMapping
    ResponseEntity<List<SongDto>> getAllSongs()
    {
        return ResponseEntity.ok(songService.retrieveSongs());
    }

    @GetMapping("/get")
    ResponseEntity<SongDto> getSongWithId(@RequestParam String id) {
        var song = songService.retrieveSongById(id);
        return ResponseEntity.ok(song);
    }

    @PostMapping("/add")
    ResponseEntity<String>  postASong(@RequestBody SongDto song) {
        var resp = songService.tryAddSong(song);
        if (resp.contains("ERROR")) {
            ResponseEntity.badRequest().body(resp);
        }

        return ResponseEntity.ok(resp);
    }
}