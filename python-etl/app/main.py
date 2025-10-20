from fastapi import FastAPI
import psycopg2
import os

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Hello from FastAPI Data Worker!!"}

@app.get("/test-db")
def test_db():
    try:
        conn = psycopg2.connect(
            host=os.getenv("DB_HOST"),
            port=os.getenv("DB_PORT"),
            user=os.getenv("DB_USER"),
            password=os.getenv("DB_PASSWORD"),
            database=os.getenv("DB_NAME"),
        )
        conn.close()
        return {"status": "✅ Connected to PostgreSQL Render!"}
    except Exception as e:
        return {"status": "❌ Connection failed", "error": str(e)}
