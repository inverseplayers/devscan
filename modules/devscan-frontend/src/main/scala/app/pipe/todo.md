package app.pipe


# 버전1. 
- raw string => parsed view => raw string ( 역으로도 가능하게)
```md

# string
raw"""안녕하세요 \n 제이름은 \n ooo 입니다."""

# string => view
"안녕하세요
 제이름은
 ooo 입니다."


# view => string
raw"""안녕하세요 \n 제이름은 \n ooo 입니다."""
```


# 버전2. 
- raw string => parsed view => raw string ( 역으로도 가능하게)

```md
raw => parsed => raw
```