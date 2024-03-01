package cs.hse.springWebJavaDemo.features.songs.controllers;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import cs.hse.springWebJavaDemo.features.songs.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music/albums")
@RequiredArgsConstructor
class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    ResponseEntity<List<AlbumDto>> getAllAlbums()  {
        return ResponseEntity.ok(albumService.retrieveAlbums());
    }

    @GetMapping("/get")
    ResponseEntity<AlbumDto> getAlbumWithId(@RequestParam String id) {
        var album = albumService.retrieveAlbumById(id);
        return ResponseEntity.ok(album);

    }

    @PostMapping("/add")
    ResponseEntity<String> postAnAlbum(@RequestBody AlbumDto album) {
        var resp = albumService.tryAddAlbum(album);
        if (resp.contains("ERROR")) {
            ResponseEntity.badRequest().body(resp);
        }

        return ResponseEntity.ok(resp);
    }
}