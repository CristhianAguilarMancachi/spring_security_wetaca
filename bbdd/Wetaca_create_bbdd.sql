-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-28 22:46:37.562

-- tables
-- Table: Cargo
CREATE TABLE Cargo (
    id_cargo serial  NOT NULL,
    descripcion_cargo varchar(20)  NOT NULL,
    id_wtc_usuario serial  NOT NULL,
    CONSTRAINT Trabajador_pk PRIMARY KEY (id_cargo)
);

-- Table: Pedido
CREATE TABLE Pedido (
    id_pedido serial  NOT NULL,
    fecha_pedido date  NOT NULL,
    cantidad_pedido int  NOT NULL,
    subtotal_pedido numeric(10,15)  NOT NULL,
    estado_pedido boolean  NOT NULL,
    ci_wtc_usuario varchar(100)  NOT NULL,
    fecha_entrega_pedido date  NOT NULL,
    hora_entrega_pedido time  NOT NULL,
    id_wtc_usuario serial  NOT NULL,
    CONSTRAINT Pedido_pk PRIMARY KEY (id_pedido)
);

-- Table: Plato
CREATE TABLE Plato (
    id_plato serial  NOT NULL,
    nombre_plato varchar(100)  NOT NULL,
    precio_plato numeric(10,15)  NOT NULL,
    detalle_plato varchar(800)  NOT NULL,
    estado_plato boolean  NOT NULL,
    ingrediente_plato varchar(800)  NOT NULL,
    seccion_plato varchar(35)  NOT NULL,
    CONSTRAINT Plato_pk PRIMARY KEY (id_plato)
);

-- Table: Ubicacion
CREATE TABLE Ubicacion (
    id_ubicacion serial  NOT NULL,
    latitud decimal(20,5)  NOT NULL,
    longitud decimal(20,5)  NOT NULL,
    descripcion_ubicacion varchar(400)  NOT NULL,
    CONSTRAINT Ubicacion_pk PRIMARY KEY (id_ubicacion)
);

-- Table: anuncio
CREATE TABLE anuncio (
    id_anuncio serial  NOT NULL,
    contador_clicks bigint  NOT NULL,
    CONSTRAINT anuncio_pk PRIMARY KEY (id_anuncio)
);

-- Table: detalle_pedido
CREATE TABLE detalle_pedido (
    id_detalle_pedido serial  NOT NULL,
    total_detalle_pedido numeric(10,15)  NOT NULL,
    tipopago_detalle_pedido varchar(50)  NOT NULL,
    id_pedido serial  NOT NULL,
    CONSTRAINT cobranza_pk PRIMARY KEY (id_detalle_pedido)
);
-- Table: plato_pedido
CREATE TABLE plato_pedido (
    id_plato_pedido serial  NOT NULL,
    id_plato serial  NOT NULL,
    id_pedido serial  NOT NULL,
    CONSTRAINT plato_pedido_pk PRIMARY KEY (id_plato_pedido)
);

-- Table: wtc_usuario
CREATE TABLE wtc_usuario (
    id_wtc_usuario serial  NOT NULL,
    ci_wtc_usuario varchar(100)  NOT NULL,
    nombre_wtc_usuario varchar(100)  NOT NULL,
    apellido_wtc_usuario varchar(100)  NOT NULL,
    correo_wtc_usuario varchar(70)  NOT NULL,
    fono_wtc_usuario varchar(10)  NOT NULL,
    id_ubicacion serial  NOT NULL,
    estado_wtc_usuario boolean  NOT NULL,
    nombreusuario_wtc_usuario varchar(100)  NOT NULL,
    contrasena_wtc_usuario varchar(100)  NOT NULL,
    CONSTRAINT Persona_pk PRIMARY KEY (id_wtc_usuario)
);

-- foreign keys
-- Reference: Pedido_Persona (table: Pedido)
ALTER TABLE Pedido ADD CONSTRAINT Pedido_Persona
    FOREIGN KEY (id_wtc_usuario)
    REFERENCES wtc_usuario (id_wtc_usuario)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Persona_Ubicacion (table: wtc_usuario)
ALTER TABLE wtc_usuario ADD CONSTRAINT Persona_Ubicacion
    FOREIGN KEY (id_ubicacion)
    REFERENCES Ubicacion (id_ubicacion)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: Trabajador_Persona (table: Cargo)
ALTER TABLE Cargo ADD CONSTRAINT Trabajador_Persona
    FOREIGN KEY (id_wtc_usuario)
    REFERENCES wtc_usuario (id_wtc_usuario)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: detalle_pedido_Pedido (table: detalle_pedido)
ALTER TABLE detalle_pedido ADD CONSTRAINT detalle_pedido_Pedido
    FOREIGN KEY (id_pedido)
    REFERENCES Pedido (id_pedido)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: plato_pedido_Pedido (table: plato_pedido)
ALTER TABLE plato_pedido ADD CONSTRAINT plato_pedido_Pedido
    FOREIGN KEY (id_pedido)
    REFERENCES Pedido (id_pedido)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- Reference: plato_pedido_Plato (table: plato_pedido)
ALTER TABLE plato_pedido ADD CONSTRAINT plato_pedido_Plato
    FOREIGN KEY (id_plato)
    REFERENCES Plato (id_plato)  
    NOT DEFERRABLE 
    INITIALLY IMMEDIATE
;

-- End of file.

