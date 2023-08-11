from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI()  # 这里名字不一定是app，名字随意


class CityInfo(BaseModel):
    province: str
    country: str
    is_affected: bool | None


@app.get("/")
async def hello_world():
    return {"hello": "world"}


@app.get("/city/{city}")
async def result(city: str, query_string: str | None = None):
    return {"city": city, "query_string": query_string}


@app.put("/city/{city}")
async def update_city(city: str, city_info: CityInfo):
    return {
        "city": city,
        "country": city_info.country,
        "is_affected": city_info.is_affected,
    }


# 启动命令： uvicorn hello_world:app  --reload
