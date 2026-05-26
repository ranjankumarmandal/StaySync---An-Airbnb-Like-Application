from fastapi import FastAPI
from app.routes.recommendation_routes import router

app = FastAPI(title="AI Recommendation Service")

app.include_router(router)