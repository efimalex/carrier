CREATE SEQUENCE transaction_number_sequence
  INCREMENT 1
  MINVALUE 10000000
  MAXVALUE 9223372036854775807
  START 10000000
  CACHE 1;
ALTER TABLE transaction_number_sequence OWNER TO dbwriter;

CREATE SEQUENCE hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1840
  CACHE 1;
ALTER TABLE hibernate_sequence OWNER TO dbwriter;

CREATE TABLE carrier_man
(
  id bigint NOT NULL,
  short_name character varying(255) NOT NULL,
  full_name character varying(255) NOT NULL,
  "description" character varying(255) NOT NULL,
  CONSTRAINT carrier_man_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE carrier_man
  OWNER TO dbwriter;


CREATE TABLE bus
(
  id bigint NOT NULL,
  state_number CHARACTER VARYING(10) NOT NULL,
  seats INT NOT NULL,
  bus_model CHARACTER VARYING(64) NOT NULL,
  carrier_man_id BIGINT NOT NULL,
  CONSTRAINT bus_pkey PRIMARY KEY (id),
  CONSTRAINT carrier_man_id_fk FOREIGN KEY (carrier_man_id)
      REFERENCES carrier_man (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bus
  OWNER TO dbwriter;

CREATE TABLE bus_route
(
  id bigint NOT NULL,
  route_number CHARACTER VARYING(64) NOT NULL,
  bus_id bigint not null,
  carrier_man_id bigint not null,
  dispatch_station_id bigint not null,
  destination_station_id bigint not null,
  CONSTRAINT bus_route_pkey PRIMARY KEY (id),
  CONSTRAINT bus_id_fk FOREIGN KEY (bus_id)
      REFERENCES bus (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT carrier_man_id_fk FOREIGN KEY (carrier_man_id)
      REFERENCES carrier_man (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bus_route
  OWNER TO dbwriter;


CREATE TABLE bus_station
(
  id bigint NOT NULL,
  station_name CHARACTER VARYING(128) NOT NULL,
  bus_route_id bigint not null,
  CONSTRAINT bus_station_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE bus_station
  OWNER TO dbwriter;

ALTER TABLE bus_route ADD CONSTRAINT destination_station_id_fk FOREIGN KEY (destination_station_id) REFERENCES bus_station (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE bus_route ADD CONSTRAINT dispatch_station_id_fk FOREIGN KEY (dispatch_station_id) REFERENCES bus_station (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;
ALTER TABLE bus_station ADD CONSTRAINT bus_route_id_fk FOREIGN KEY (bus_route_id) REFERENCES bus_route (id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE timetable
(
  id bigint NOT NULL,
  bus_route_id bigint NOT NULL,
  date_departure date NOT NULL,
  time_departure time NOT NULL,
  arrival_date date NOT NULL,
  arrival_time time NOT NULL,
  CONSTRAINT timetable_pkey PRIMARY KEY (id),
  CONSTRAINT bus_route_id_fk FOREIGN KEY (bus_route_id)
      REFERENCES bus_route (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE timetable
  OWNER TO dbwriter;

CREATE TABLE station_price_history
(
  id bigint NOT NULL,
  start_period timestamp NOT NULL,
  end_period timestamp NOT NULL,
  forward_price NUMERIC(13,2) NOT NULL,
  opposite_price NUMERIC(13,2) NOT NULL,
  bus_station_id bigint not null,
  CONSTRAINT station_price_history_pkey PRIMARY KEY (id),
  CONSTRAINT bus_station_id_fk FOREIGN KEY (bus_station_id)
      REFERENCES bus_station (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE station_price_history
  OWNER TO dbwriter;