package cs.hse.springWebJavaDemo.features.songs.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SongDto {
    private String id;
    private String title;
    private String albumId;
}