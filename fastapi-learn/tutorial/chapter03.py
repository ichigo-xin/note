from enum import Enum

from fastapi import APIRouter, Path, Query

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


@app03.get("/files/file")
def filepath1(file_path: str):
    return f"The file path is {file_path}"


@app03.get("/files/{file_path:path}")  # 通过path parameters传递文件路径
def filepath(file_path: str):
    return f"The file path is {file_path}"


@app03.get("/path_/{num}")
def path_params_validate(
        num: int = Path(..., title="Your Number", description="不可描述", ge=1, le=10)
):
    return num


"""查询参数和字符串验证"""

@app03.get("/query")
def page_limit(page: int = 1, limit: int | None = None):
    if limit:
        return {'page': page, 'limit': limit}
    return {'page': page}


@app03.get("/query/bool/conversion")
def type_conversion(param: bool = False):
    return param


@app03.get("/query/validations")
def query_params_validations(
        value: str = Query(..., min_length=8, max_length=16, regex="^a"),
        values: list[str] = Query(default=["v1", "v2"], alias="alias_name")
):
    return value, values
