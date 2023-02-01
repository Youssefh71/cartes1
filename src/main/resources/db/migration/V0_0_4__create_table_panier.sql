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


