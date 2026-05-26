from fastapi import APIRouter
from app.models.search_request import SearchRequest
from app.services.recommendation_service import recommend

router = APIRouter()

@router.post("/recommend")
def get_recommendations(request: SearchRequest):
    return recommend(request.query)