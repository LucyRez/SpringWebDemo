package cs.hse.springWebJavaDemo.features.songs.repositories;

import cs.hse.springWebJavaDemo.features.songs.dto.AlbumDto;
import cs.hse.springWebJavaDemo.features.songs.dto.SongDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Repository
public class AlbumRepository {

    private final ArrayList<AlbumDto> albums = new ArrayList<>(Arrays.asList(
            new AlbumDto("1", "Блэкаут", "https://images.genius.com/c3a120256bfd8d380df0a38e238b11c4.1000x1000x1.jpg",
                    "Операция пластилин"),
            new AlbumDto("2", "Scaled and Icy", "URL2", "Twenty One Pilots"),
            new AlbumDto("3", "Punisher", "URL3", "Phoebe Bridgers"),
            new AlbumDto("4", "Innuendo", "URL4", "Queen"))
    );

    private final ArrayList<SongDto> songs = new ArrayList<>( Arrays.asList(
            new SongDto("1", "These Are The Days Of Our lives", "4"),
            new SongDto("2", "Garden Song", "3"),
            new SongDto("3", "Formidable", "2"),
            new SongDto("4", "Хоровод", "1"))
    );

    public enum Status {
        ERROR,
        SUCCESS
    }

    public List<AlbumDto> getAllAlbums() {
        return albums;
    }
    public List<SongDto> getAllSongs() { return songs; }


    public Status addAlbum(AlbumDto album) {
        if (albums.stream().anyMatch(n -> n.getId().equals(album.getId()))) return Status.ERROR;
        albums.add(album);
        return Status.SUCCESS;
    }
    public Status addSong(SongDto songDto) {
        if (albums.stream().anyMatch(n -> n.getId().equals(songDto.getAlbumId()))) {
            songs.add(songDto);
            return Status.SUCCESS;
        }

        return Status.ERROR;
    }


}