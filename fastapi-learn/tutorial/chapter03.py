from enum import Enum

from fastapi import APIRouter

app03 = APIRouter()

"""路径参数和数字验证"""


@app03.get("/path/parameters")
def path_params01():
    return {"message": "This is a message"}


@app03.get("/path/{parameters}")  # 函数的顺序就是路由的顺序
def path_params01(parameters: str):
    return {"message": parameters}


class CityName(str, Enum):
    Beijing = "Beijing China"
    Shanghai = "Shanghai China"


@app03.get("/enum/{city}")
async def lastest(city: CityName):
    if city == CityName.Shanghai:
        return {"city_name": city, "confirmed": 1492, "death": 7}
    if city == CityName.Beijing:
        return {"city_name": city, "confirmed": 971, "death": 9}
    return {"city_name": city, "latest": "unknown"}
