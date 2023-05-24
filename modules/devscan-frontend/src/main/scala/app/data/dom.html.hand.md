# txt
```scala
package app.parseto.common.parser
import io.circe.parser.*
import io.circe.{Json, JsonObject}

def string2json(jsonString: String) =
  decode[Json](jsonString) match {
    case Left(error) => {
      Json.True
    }
    case Right(data) => data
  }
```

# span 넣음
```scala
 div(
  style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
)(
  div(
    div(style := "line-height: 17px;")(
      div(
        span(style := "color: #569cd6;")("package"),
        span("app.parseto.common.parser")
      ),
      div(
        span(style := "color: #569cd6;")("import"),
        span("io.circe.parser.*")
      ),
      div(
        span(style := "color: #569cd6;")("import"),
        span("io.circe.{"),
        span(style := "color: #4ec9b0;")("Json"),
        span(","),
        span(style := "color: #4ec9b0;")("JsonObject"),
        span("}")
      ),
      br,
      div(
        span(style := "color: #569cd6;")("def"),
        span(style := "color: #dcdcaa;")("string2json"),
        span("("),
        span(style := "color: #9cdcfe;")("jsonString"),
        span(":"),
        span(style := "color: #4ec9b0;")("String"),
        span(")"),
        span(style := "color: #d4d4d4;")("=")
      ),
      div(
        span("decode["),
        span(style := "color: #4ec9b0;")("Json"),
        span("](jsonString)"),
        span(style := "color: #c586c0;")("match"),
        span("{")
      ),
      div(
        span(style := "color: #c586c0;")("case"),
        span(style := "color: #4ec9b0;")("Left"),
        span("(error)"),
        span(style := "color: #d4d4d4;")("=>"),
        span("{")
      ),
      div(
        span(style := "color: #4ec9b0;")("Json"),
        span("."),
        span(style := "color: #4ec9b0;")("True")
      ),
      div("}"),
      div(
        span(style := "color: #c586c0;")("case"),
        span(style := "color: #4ec9b0;")("Right"),
        span("(data)"),
        span(style := "color: #d4d4d4;")("=>"),
        span("data")
      ),
      div("}"),
      br
    )
  )
)

```

# txt => html 한줄 
 ```html
<div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;"><div><div style="line-height: 17px;"><div><span style="color: #569cd6;">package</span> app.parseto.common.parser</div><div><span style="color: #569cd6;">import</span> io.circe.parser.*</div><div><span style="color: #569cd6;">import</span> io.circe.{<span style="color: #4ec9b0;">Json</span>, <span style="color: #4ec9b0;">JsonObject</span>}</div><br><div><span style="color: #569cd6;">def</span> <span style="color: #dcdcaa;">string2json</span>(<span style="color: #9cdcfe;">jsonString</span>: <span style="color: #4ec9b0;">String</span>) <span style="color: #d4d4d4;">=</span></div><div>  decode[<span style="color: #4ec9b0;">Json</span>](jsonString) <span style="color: #c586c0;">match</span> {</div><div>    <span style="color: #c586c0;">case</span> <span style="color: #4ec9b0;">Left</span>(error) <span style="color: #d4d4d4;">=&gt;</span> {</div><div>      <span style="color: #4ec9b0;">Json</span>.<span style="color: #4ec9b0;">True</span></div><div>    }</div><div>    <span style="color: #c586c0;">case</span> <span style="color: #4ec9b0;">Right</span>(data) <span style="color: #d4d4d4;">=&gt;</span> data</div><div>  }</div><br></div></div></div>
 ```

# html=>tyrian  공백소실
```scala
div(style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;""")(
div(
div(style := "line-height: 17px;")(
div(
span(style := "color: #569cd6;")(
"package"),
"app.parseto.common.parser"),
div(
span(style := "color: #569cd6;")(
"import"),
"io.circe.parser.*"),
div(
span(style := "color: #569cd6;")(
"import"),
"io.circe.{",
span(style := "color: #4ec9b0;")(
"Json"),
",",
span(style := "color: #4ec9b0;")(
"JsonObject"),
"}"),
br,
div(
span(style := "color: #569cd6;")(
"def"),
span(style := "color: #dcdcaa;")(
"string2json"),
"(",
span(style := "color: #9cdcfe;")(
"jsonString"),
":",
span(style := "color: #4ec9b0;")(
"String"),
")",
span(style := "color: #d4d4d4;")(
"=")),
div(
"decode[",
span(style := "color: #4ec9b0;")(
"Json"),
"](jsonString)",
span(style := "color: #c586c0;")(
"match"),
"{"),
div(
span(style := "color: #c586c0;")(
"case"),
span(style := "color: #4ec9b0;")(
"Left"),
"(error)",
span(style := "color: #d4d4d4;")(
"=>"),
"{"),
div(
span(style := "color: #4ec9b0;")(
"Json"),
".",
span(style := "color: #4ec9b0;")(
"True")),
div(
"}"),
div(
span(style := "color: #c586c0;")(
"case"),
span(style := "color: #4ec9b0;")(
"Right"),
"(data)",
span(style := "color: #d4d4d4;")(
"=>"),
"data"),
div(
"}"),
br)))

```



```md
# 1줄일때 css
color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;

# package app
<div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;">
  <span style="color: #569cd6;">package</span> 
  app
</div>


# 1줄일때 css
color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;

# package app
<div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;">
  <div><span style="color: #569cd6;">package</span> app.parseto.common.parser</div>
  <div><span style="color: #569cd6;">import</span> io.circe.parser.*</div>
</div>
```