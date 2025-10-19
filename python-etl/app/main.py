from fastapi import FastAPI
import requests

app = FastAPI()

@app.get("/")
def root():
    return {"message": "Hello from FastAPI Data Worker!"}
