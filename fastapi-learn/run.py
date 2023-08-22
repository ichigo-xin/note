import uvicorn
from fastapi import FastAPI

from tutorial import app03, app04, app05

app = FastAPI()
app.include_router(app03, prefix="/chapter03", tags=["chapter03"])
app.include_router(app04, prefix="/chapter04", tags=["chapter04"])
app.include_router(app05, prefix="/chapter05", tags=["chapter05"])

if __name__ == "__main__":
    uvicorn.run(app="run:app", host="0.0.0.0", port=8000, reload=True, workers=4)
