-- Table 'users'
CREATE TABLE IF NOT EXISTS `users` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) COLLATE utf8_bin NOT NULL,
  `password` varchar(100) COLLATE utf8_bin NOT NULL,
  `registrationDate` datetime NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1;

-- table 'userroles`
CREATE TABLE IF NOT EXISTS `userroles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `roleId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKUserRolesUserID` (`userId`),
  KEY `FKUserRolesRoleID` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=1 ;

-- table `roles`
CREATE TABLE IF NOT EXISTS `roles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roles` varchar(25) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `roles` (`roles`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_bin AUTO_INCREMENT=3;

-- table `roles`
INSERT INTO `roles` (`id`, `roles`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

-- foreign keys `userroles`
ALTER TABLE `userroles`
  ADD CONSTRAINT `FKUserRolesRoleID` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FKUserRolesUserID` FOREIGN KEY (`userId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;


INSERT INTO users VALUES (1, 'admin@gmail.com', 'password', 123154545443 );
INSERT INTO userroles VALUES (1, 1);
INSERT INTO userroles VALUES (1, 2);


-- add user with id 1 roles with id 1
INSERT INTO  `orc`.`userroles` (
  `userId` ,
  `roleId`
)
VALUES (
  '1',  '1'
);


-- table `roles`
INSERT INTO `roles` VALUES
  (1, 'ROLE_ADMIN'),
  (2, 'ROLE_USER');

-- foreign keys `userroles`
ALTER TABLE `userroles`
ADD CONSTRAINT `FKUserRolesRoleID` FOREIGN KEY (`roleId`) REFERENCES `roles` (`id`) ON DELETE CASCADE,
ADD CONSTRAINT `FKUserRolesUserID` FOREIGN KEY (`userId`) REFERENCES `users` (`ID`) ON DELETE CASCADE;


INSERT INTO users VALUES (1, 'admin', 'admin', 'admin', 'anton', '4297f44b13955235245b2497399d7a93', '+380675407488', CURDATE(), 'mele', 'Romankov' );

INSERT INTO userroles VALUES (1, 1);
INSERT INTO userroles VALUES (1, 2);

-- 4297f44b13955235245b2497399d7a93 == 123123