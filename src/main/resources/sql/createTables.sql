create table album(
    id text primary key,
    title text,
    artist text,
    image_Url text
);

create table songs(
    id text primary key,
    title text,
    album_Id text,
    constraint fk_album
        foreign key(album_Id)
            references album(id)
);

