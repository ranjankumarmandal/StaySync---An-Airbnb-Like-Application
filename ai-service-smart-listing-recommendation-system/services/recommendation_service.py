from sentence_transformers import SentenceTransformer
from sklearn.metrics.pairwise import cosine_similarity
from app.data.listings import listings
import numpy as np

model = SentenceTransformer('all-MiniLM-L6-v2')

titles = [l["title"] for l in listings]
embeddings = model.encode(titles)


def recommend(query: str):

    query_embedding = model.encode([query])

    scores = cosine_similarity(query_embedding, embeddings)[0]

    results = []

    for i, score in enumerate(scores):
        results.append({
            "listingId": listings[i]["id"],
            "title": listings[i]["title"],
            "score": float(score)
        })

    results = sorted(results, key=lambda x: x["score"], reverse=True)

    return results