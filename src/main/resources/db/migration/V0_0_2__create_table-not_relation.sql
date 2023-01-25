-- table de référence banque
CREATE TABLE IF NOT EXISTS banque
(
    id_banque BIGSERIAL PRIMARY KEY ,
    name VARCHAR(100)   NOT NULL,
    iban  VARCHAR(100)   NOT NULL,
    bic  VARCHAR(100)   NOT NULL,
   date_banque DATE NOT NULL
);

-- table de référence conversion
CREATE TABLE IF NOT EXISTS conversion
(
    id_conversion BIGSERIAL PRIMARY KEY ,
    taux FLOAT  NOT NULL,
   date_conversion DATE NOT NULL
);

-- table de référence frais
CREATE TABLE IF NOT EXISTS markup
(
    id_frais BIGSERIAL PRIMARY KEY ,
    montant FLOAT   NOT NULL,
   date_frais DATE NOT NULL
);

-- table de référence tva
CREATE TABLE IF NOT EXISTS tva
(
    id_tva BIGSERIAL PRIMARY KEY ,
    montant FLOAT   NOT NULL,
   date_tva DATE NOT NULL
);

-- table de référence contact
CREATE TABLE IF NOT EXISTS contact
(
    id_contact BIGSERIAL PRIMARY KEY ,
    mail VARCHAR(100)  NOT NULL,
   phone VARCHAR(20) NOT NULL
);