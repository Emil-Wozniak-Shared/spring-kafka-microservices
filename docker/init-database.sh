#!/bin/bash
set -e

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE USER microservices WITH PASSWORD 'microservices';
    ALTER USER microservices WITH LOGIN;
    CREATE DATABASE microservices;
    GRANT ALL PRIVILEGES ON DATABASE microservices TO microservices;
EOSQL