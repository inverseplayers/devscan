```scala
   import scala.util.parsing.json.JSON

   val json =
     "{\"name\":\"Sammy\",\"email\":\"sammy@example.com\",\"plan\":\"Pro\"}"
     val obj = JSON.parseFull(json).get.asInstanceOf[Map[String, Any]]
     var expanded = false
     val entries = obj.toSeq
     val t = obj.getClass.getSimpleName
     val value = t match {
       case "Map"  => s"Object[{entries.length}]"
       case "List" => s"Array[{entries.length}]"
       case _      => json
     }

```

```js
   const obj = JSON.parse(json)
    let expanded = false
    const entries = Object.entries(obj)
    const type = Object.prototype.toString.call(obj)	// 객체 타입을 알 수 있음
    let value   = 0
    if (type === '[object Array]') {
        value = `Array[${entries.length}]`
    } else if (type === '[object Object]'){
        value = `Object[${entries.length}]`
    }else {
        value = json
    }
```

