
--# Adiciona usuários na tabela

INSERT INTO users (name) VALUES ('Abgonlido Alves');

INSERT INTO users (name) VALUES ('Juvenal Juvencio')

INSERT INTO users (name) VALUES ('Beto Santos');

--# Adiciona músicas na tabela

INSERT INTO music (name) VALUES ('Gustavo Lima - Bloqueado');

INSERT INTO music (name) VALUES ('Edson Gomes - Camelo');

INSERT INTO music (name) VALUES ('Bee Gees - How depp your love');

INSERT INTO music (name) VALUES ('Cutting Crew - (I Just) Died In Your Arms');

INSERT INTO music (name) VALUES ('Green Day - American Idiot');

INSERT INTO music (name) VALUES ('Simone e Simaria - Sao amores');

--# Adiciona playlist na tabela

INSERT INTO playlist (name) VALUES ('Internacional de novelas');

INSERT INTO playlist (name) VALUES ('Reggae misto vol.7');

INSERT INTO playlist (name) VALUES ('O Melhor da MPB');

INSERT INTO playlist (name) VALUES ('Pop Rock internacional');

INSERT INTO playlist (name) VALUES ('Paredao  dezembro');

--# Adiciona playlist para o usuário

INSERT INTO user_playlists (users_id, playlists_id) VALUES (1, 1);
INSERT INTO user_playlists (users_id, playlists_id) VALUES (2, 2);
INSERT INTO user_playlists (users_id, playlists_id) VALUES (2, 3);

--# Adiciona música nas playlists

INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (1, 1);
INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (2, 2);
INSERT INTO playlist_musics (playlists_id, musics_id) VALUES (2, 3);


