create database kybTraining;

-- SHOW GRANTS FOR 'ohgiraffers'@'%';

GRANT ALL PRIVILEGES ON `kybTraining`.* TO `ohgiraffers`@`%`;

use kybTraining;

DROP TABLE IF EXISTS PRODUCT CASCADE;
DROP TABLE IF EXISTS CATEGORY;
DROP TABLE IF EXISTS BRAND;

CREATE TABLE CATEGORY (
                          CATEGORY_CODE INT PRIMARY KEY,
                          CATEGORY_NAME VARCHAR(255)
);

CREATE TABLE BRAND (
                       BRAND_CODE INT PRIMARY KEY,
                       BRAND_NAME VARCHAR(255)
);

CREATE TABLE PRODUCT (
                         PRODUCT_CODE INT PRIMARY KEY AUTO_INCREMENT,
                         PRODUCT_NAME VARCHAR(255),
                         REGULAR_PRICE INT,
                         DISCOUNT_RATE INT CHECK ( DISCOUNT_RATE >= 0 AND DISCOUNT_RATE <= 100),
                         REF_CATEGORY_CODE INT,
                         REF_BRAND_CODE INT,

                         FOREIGN KEY (REF_CATEGORY_CODE) REFERENCES CATEGORY(CATEGORY_CODE),
                         FOREIGN KEY (REF_BRAND_CODE) REFERENCES BRAND(BRAND_CODE)
);

INSERT INTO CATEGORY (CATEGORY_CODE, CATEGORY_NAME)
VALUES
    (1, 'top'),
    (2, 'bottom'),
    (3, 'shoes'),
    (4, 'hat'),
    (5, 'bag');

INSERT INTO BRAND (BRAND_CODE, BRAND_NAME)
VALUES
    (1, 'Mizuno'),
    (2, 'Asics'),
    (3, 'NIKE'),
    (4, 'Adidas'),
    (5, 'OBEY');

INSERT INTO PRODUCT (PRODUCT_NAME, REGULAR_PRICE, DISCOUNT_RATE, REF_CATEGORY_CODE, REF_BRAND_CODE)
VALUES

    ('빨간색 티셔츠', 29000, 4, 1, 5),
    ('주황색 티셔츠', 31000, 6, 1, 1),
    ('초록색 모자', 40000, 8, 4, 1),
    ('남색 티셔츠', 35000, 1, 1, 5),
    ('보라색 티셔츠', 50000, 0, 1, 1),
    ('파랑색 티셔츠', 25000, 10, 1, 4),
    ('주운 모자', 600, 100, 4, 1),
    ('검정색 모자', 30000, 2, 4, 2),
    ('빨간색 모자', 29000, 4, 4, 3),
    ('주운 바지', 500000, 100, 2, 2),
    ('검정색 가방', 30000, 2, 5, 2),
    ('빨간색 가방', 29000, 4, 5, 3),
    ('주황색 가방', 31000, 6, 5, 4),
    ('주운티셔츠', 3000, 100, 1, 3),
    ('검정색 티셔츠', 30000, 2, 1, 4),
    ('파랑색 모자', 25000, 10, 4, 2),
    ('남색 모자', 35000, 1, 4, 3),
    ('초록색 가방', 40000, 8, 5, 1),
    ('파랑색 가방', 25000, 10, 5, 2),
    ('남색 가방', 35000, 1, 5, 3),
    ('노란색 가방', 10000, 7, 5, 5),
    ('파랑색 신발', 25000, 10, 3, 2),
    ('검정색 바지', 30000, 2, 2, 3),
    ('빨간색 바지', 29000, 4, 2, 4),
    ('주황색 바지', 31000, 6, 2, 5),
    ('노란색 바지', 10000, 7, 2, 1),
    ('노란색 티셔츠', 10000, 7, 1, 2),
    ('황금색 바지', 80000, 25, 2, 1),
    ('주운 신발', 300, 100, 3, 1),
    ('검정색 신발', 30000, 2, 3, 2),
    ('빨간색 신발', 29000, 4, 3, 3),
    ('주황색 신발', 31000, 6, 3, 4),
    ('초록색 티셔츠', 40000, 8, 1, 3),
    ('주황색 모자', 31000, 6, 4, 4),
    ('노란색 모자', 10000, 7, 4, 5),
    ('초록색 바지', 40000, 8, 2, 2),
    ('파랑색 바지', 25000, 10, 2, 3),
    ('남색 바지', 35000, 1, 2, 4),
    ('보라색 바지', 50000, 0, 2, 5),
    ('노란색 신발', 10000, 7, 3, 5),
    ('초록색 신발', 40000, 8, 3, 1),
    ('보라색 모자', 50000, 0, 4, 4),
    ('황금색 모자', 707000, 25, 4, 5),
    ('주운 가방', 800, 100, 5, 1),
    ('남색 신발', 35000, 1, 3, 3),
    ('보라색 신발', 50000, 0, 3, 4),
    ('황금색 신발', 840000, 25, 3, 5),
    ('보라색 가방', 50000, 0, 5, 4),
    ('황금색 가방', 901000, 25, 5, 5);

SELECT * FROM PRODUCT;