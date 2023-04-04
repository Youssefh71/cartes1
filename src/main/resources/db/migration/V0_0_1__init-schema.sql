CREATE SCHEMA IF NOT EXISTS cmdecarte;

-- table de référence  banque
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
    id_markup BIGSERIAL PRIMARY KEY ,
    montant FLOAT   NOT NULL,
   date_markup DATE NOT NULL
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

-- table de référence  client
CREATE TABLE IF NOT EXISTS client
(
    id_client BIGSERIAL PRIMARY KEY ,
    langue VARCHAR(5) NOT NULL,
    destinataire VARCHAR(100),
    name VARCHAR(100)   NOT NULL,
    adresse VARCHAR(255)   NOT NULL,
    adresse2 VARCHAR(255),
    adresse3 VARCHAR(255),
    ville  VARCHAR(100)   NOT NULL,
    boite_postal VARCHAR(100),
    cedex VARCHAR(50),
    cs VARCHAR(50),
    zip_code VARCHAR(100)   NOT NULL,
    pays VARCHAR(100) NOT NULL
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

-- table de référence order
CREATE TABLE IF NOT EXISTS order_Panier
(
    id_order BIGSERIAL PRIMARY KEY

);

-- table de référence orderHeader
CREATE TABLE IF NOT EXISTS Order_Header
(
    id_orderHeader BIGSERIAL PRIMARY KEY,
    ordering_system INT  NOT NULL,
    order_type INT  NULL,
    reference_number VARCHAR(100) NULL,
    distributor_id INT  NULL,
    distributor_contact VARCHAR(100) NULL,
    optional_delivery_email VARCHAR(100) NULL,
    user_id INT  NULL,
    permit_media VARCHAR(100) NULL,
    permit_all  VARCHAR(100) NULL,
    language_code VARCHAR(5)   NOT NULL
);

-- table de référence  cell
CREATE TABLE IF NOT EXISTS Cell
(
    id_cell BIGSERIAL PRIMARY KEY,
    cell_name VARCHAR(20)   NOT NULL,
    cell_edtn VARCHAR(20)   NULL,
    Service_type INT NOT NULL
);
