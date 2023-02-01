-- table de référence client
CREATE TABLE IF NOT EXISTS client
(
    id_client BIGSERIAL PRIMARY KEY ,
    name VARCHAR(100)   NOT NULL,
    adresse VARCHAR(255)   NOT NULL,
    adresse2 VARCHAR(255)   NOT NULL,
    ville  VARCHAR(100)   NOT NULL,
    zip_code VARCHAR(100)   NOT NULL,
    pays VARCHAR(100)
);

-- table de référence licensee
CREATE TABLE IF NOT EXISTS licensee
(
    id_licensee BIGSERIAL PRIMARY KEY,
    name VARCHAR(100)  NOT NULL,
    francisation VARCHAR(255) 
);

-- table de référence  devis
CREATE TABLE IF NOT EXISTS devis
(
    id_devis BIGSERIAL PRIMARY KEY,
    numero VARCHAR(100)   NOT NULL,
    validity INT NOT NULL,
    titre VARCHAR(255) NOT NULL,
    date_devis DATE NOT NULL

);

-- table de référence userPermit
CREATE TABLE IF NOT EXISTS user_Permit
(
    id_permit BIGSERIAL PRIMARY KEY,
    name VARCHAR(100),
    numero VARCHAR(100)
);
