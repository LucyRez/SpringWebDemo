package cs.hse.springWebJavaDemo.features.songs.services;



import cs.hse.springWebJavaDemo.features.songs.dto.SongDto;
import cs.hse.springWebJavaDemo.features.songs.repositories.AlbumRepository;
import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private final AlbumRepository albumRepository;

    public List<SongDto> retrieveSongs() {
        return albumRepository.getAllSongs();
    }

    public List<AlbumDto> retrieveAlbums() {
        return albumRepository.getAllAlbums();
    }

    public SongDto retrieveSongById(String id) {
        return albumRepository.getAllSongs().stream().filter(s -> s.getId().equals(id)).findAny().orElseThrow();
    }


    public AlbumDto retrieveAlbumById(String id) {
        return albumRepository.getAllAlbums().stream().filter(albumDto -> albumDto.getId().equals(id)).findAny().orElseThrow();
    }

    public String tryAddSong(SongDto songDto) {
        if (albumRepository.addSong(songDto) == AlbumRepository.Status.SUCCESS) {
            return "Song $songDto was successfully added";
        }

        return "ERROR: Album for this song does not exist";
    }

    public String tryAddAlbum(AlbumDto albumDto) {
        if (albumRepository.addAlbum(albumDto) == AlbumRepository.Status.SUCCESS) {
            return "Album $albumDto was successfully added";
        }

        return "ERROR: This album already exists";
    }


}