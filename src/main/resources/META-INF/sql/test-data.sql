-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO category (NAME) VALUES ('Spring Framework');
INSERT INTO category (NAME) VALUES ('Java');
INSERT INTO category (NAME) VALUES ('Design Patterns');
INSERT INTO category (NAME) VALUES ('Scala');

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO book (CATEGORY_ID, ISBN, TITLE, PRICE_DECIMAL) VALUES ('1', '0764543857', 'Expert One-on-One J2EE Design and Development', '59.99');
INSERT INTO book (CATEGORY_ID, ISBN, TITLE, PRICE_DECIMAL) VALUES ('1', '0764574833', 'Professional Java Development with the Spring Framework', '28.72');
INSERT INTO book (CATEGORY_ID, ISBN, TITLE, PRICE_DECIMAL) VALUES ('3', '0321127420', 'Patterns of Enterprise Application Architecture', '52.49');
INSERT INTO book (CATEGORY_ID, ISBN, TITLE, PRICE_DECIMAL) VALUES ('4', '1935182706', 'Scala in Depth', '32.48');
INSERT INTO book (CATEGORY_ID, ISBN, TITLE, PRICE_DECIMAL) VALUES ('2', '0321349806', 'The Java Programming Language', '31.75');

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Rod', 'Johnson', 'Founder of Spring Framework');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Jorgen', 'Holler', 'Lead Spring Framework Developer');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Martin', 'Fowler', 'Prominent Software Architect and Designer');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Joshua', 'Suereth', 'Scala Expert');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('James', 'Gosling', 'Founder of Java Language');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Ken', 'Arnold', 'Distinguished Software Engineer');
INSERT INTO author (FIRST_NAME, LAST_NAME, DESCRIPTION) VALUES ('Craig', 'Walls', 'Well Known Spring Framework Writer');


-- ----------------------------
-- Records of author_book
-- ----------------------------
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('1','1');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('2','1');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('2','2');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('3','3');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('4','4');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('5','5');
INSERT INTO author_book (AUTHOR_ID, BOOK_ID) VALUES ('5','6');
