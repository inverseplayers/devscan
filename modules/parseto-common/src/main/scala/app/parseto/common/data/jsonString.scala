package app.parseto.common.data

object JsonString:
  val 이력서1 = raw"""안녕하세요 \n 제이름은 \n ooo 입니다."""
  val app = raw"""
  {
    "app": {
      "구인": {
        "프론트엔드":  [{"이력서1": "${이력서1}"}, {"이력서2" : "내용"}],
        "벡엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}]
      },
      "구직": {
        "프론트엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}],
        "벡엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}]
      }
    }
  }
  """
  val app2 = raw"""
  {
    "app": {
      "구인": {
        "프론트엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}],
        "벡엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}],
      },
      "구직": {
        "프론트엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}],
        "벡엔드":  [{"이력서1": "내용"}, {"이력서2" : "내용"}],
      }
    }
  }
  """
  val ex_fruits = raw"""
  {
    "과일": ["사과",{"딸기": "딸기맛바나나"},"포도","배","사과","딸기","포도","배","사과","딸기","포도","배","사과","딸기","포도1","나무"],
    "사과" : "달아",
    "_number" : 1,
    "_null" : null,
    "_bool" : true,
    "직업" : {"공무원": "1급" , "의사" : "대학병원"},
    "deep" : {"d1": {"d2": "d2-value"}} ,
    "이력서": "안녕하세요? \n 저는 000 입니다. \n 반갑습니다!"
    
  } 
  
  """

  // "직업" : ["공무원": {"교사": "김교사", "경찰": null } ]
  val fruits = s"""{"과일": ["사과","딸기","포도","배"]}"""
