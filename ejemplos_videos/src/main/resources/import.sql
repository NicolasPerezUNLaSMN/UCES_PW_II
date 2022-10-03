INSERT INTO `user` (`id`,`enabled`,`password`,`username`) VALUES (1,b'1',"$2a$10$GXxom1zEvTD4PsqziRPD..5vdwWYZyqT5BvUCQWEHWGNERlVZ9KKe","Nykolai");
INSERT INTO `user_role` (`id`,`role`,`user_id`) VALUES(1,"ROLE_1","1");




INSERT INTO `avatar` VALUES (1,'brenda@hotmail.com','www.brenda.com','Captura de pantalla (1).png'),(2,'nico@gmail.com','www.nico.com','Captura de pantalla (1).png');
INSERT INTO `persona` VALUES (1,'2022-10-02 20:30:56.037030',33,'Brenda','Honduras',71,'2022-10-02 20:30:56.037030',1),(2,'2022-10-02 20:34:47.578370',32,'Nicolas','Argentina',68,'2022-10-02 20:34:47.578370',2);


INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('1', 'Brasil', '1');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('2', 'Belgica', '2');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('3', 'Argentina', '3');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('4', 'Francia', '4');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('5', 'Inglaterra', '5');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('6', 'España', '6');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('7', 'Paises Bajos', '7');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('8', 'Portugal', '8');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('9', 'Dinamarca', '9');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('10', 'Alemania', '10');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('11', 'Mexico', '11');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('12', 'Uruguay', '12');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('13', 'EEUU', '13');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('14', 'Croacia', '14');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('15', 'Suiza', '15');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('16', 'Senegal', '16');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('17', 'Gales', '17');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('18', 'Iran', '18');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('19', 'Marruecos', '19');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('20', 'Japon', '20');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('21', 'Serbia', '21');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('22', 'Polonia', '22');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('23', 'Corea del Sur', '23');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('24', 'Túnez', '24');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('25', 'Costa Rica', '25');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('26', 'Camerún', '26');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('27', 'Australia', '27');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('28', 'Canada', '28');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('29', 'Ecuador', '29');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('30', 'Qatar', '30');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('31', 'Arabia', '31');
INSERT INTO `pais` (`id`, `nombre`, `ranking`) VALUES ('32', 'Ghana', '32');

INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Messi', '10', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Neymar', '34', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Martinez', '1', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Otamendi', '2', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Ronaldo', '44', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Gutierrez', '101', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Martinez', '1', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Otamendi', '2', '1');
INSERT INTO `figurita` (`descripcion`, `numero`, `persona_id`) VALUES ('Ronaldo', '44', '1');