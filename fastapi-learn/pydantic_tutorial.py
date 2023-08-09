from datetime import date, datetime

from pydantic import BaseModel, ValidationError, constr
from sqlalchemy import ARRAY, Column, Integer, String
from sqlalchemy.orm.decl_api import declarative_base


class User(BaseModel):
    id: int  # 必填字段
    name: str = "John Doe"  # 有默认值，选填字段
    signup_ts: datetime | None = None  # 选填字段
    friends: list[int] = []  # 列表中的元素必须是int类型或者可以直接转换为int类型的字符串


external_data = {
    "id": "123",
    "signup_ts": "2017-06-01 12:22",
    "friends": [1, "2", "3"],
}

print("\033[1;31m" + "---------pydantic的基本用法-------" + "\033[0m")

user = User(**external_data)
print(user.id)
print(repr(user.signup_ts))
print(user.model_dump())

print("\033[1;31m" + "---------校验处理失败-------" + "\033[0m")
try:
    User(signup_ts="broken", friends=[1, 2, "not number"])
except ValidationError as e:
    print(e.json())

print("\033[1;31m" + "---------模型类的属性和方法-------" + "\033[0m")
print(user.model_dump())
print(user.model_copy())
print(User.model_validate(obj=external_data))  # 校验数据
with open('user.json') as f:
    json_data = f.read()

# path.write_text('{"id": "12345", "signup_ts": "2017-06-01 12:22", "friends": [1, "2", "3"]}')
print(User.model_validate_json(json_data))
print(user.model_fields.keys())

print("\033[1;31m" + "---------递归模型-------" + "\033[0m")


class Sound(BaseModel):
    sound: str


class Dog(BaseModel):
    birthday: date
    weight: float | None
    sound: list[Sound]


dog = Dog(birthday=date.today(), weight=6.6, sound=[{"sound": "wang wang ~"}, {"sound": "ying ying ~"}])
print(dog)

print("\033[1;31m" + "---------ORM模型：从类实例创建符合ORM对象的模型-------" + "\033[0m")

Base = declarative_base()


class CompanyOrm(Base):
    __tablename__ = 'companies'
    id = Column(Integer, primary_key=True, nullable=False)
    public_key = Column(String(20), unique=True, nullable=False, index=True)
    name = Column(String(63), unique=True)
    domains = Column(ARRAY(String(255)))


class CompanyMode(BaseModel):
    id: int
    public_key: constr(max_length=20)
    name: constr(max_length=63)
    domains: list[constr(max_length=255)]

    class Config:
        from_attributes = True  # 使用 from_attributes 配置项
        orm_mode = True


co_orm = CompanyOrm(id=1, public_key='muke', name='testing', domains=['123', '456'])

company_model = CompanyMode.from_orm(co_orm)  # 使用 from_orm 方法
print(company_model)
