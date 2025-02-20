#!/bin/bash
set -e

echo "Aguardando o PostgreSQL iniciar..."
until pg_isready -h db -p 5432 -U "$DB_USER"; do
  sleep 2
done

echo "PostgreSQL está pronto! Executando init.sql..."
psql -U "$DB_USER" -d "$POSTGRES_DB" -f /docker-entrypoint-initdb.d/init.sql

echo "Script SQL executado com sucesso!"
exec "$@"
