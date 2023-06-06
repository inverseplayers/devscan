package app
import tyrian.*
import tyrian.Html.*

// vscode =>  복붙 html => 스페이스 소실발생  => converter
// https://simerplaha.github.io/html-to-scala-converter/

// 띄어쓰기 = &nbsp;
// const  a = "1 " == const&npsp;&npsp;a&npsp;=&npsp;"1&npsp;"
//
def const_a_1 =
  """<span><span class="mtk6">const</span><span class="mtk1">&nbsp;&nbsp;</span><span class="mtk19">a</span><span class="mtk1">&nbsp;</span><span class="mtk3">=</span><span class="mtk1">&nbsp;</span><span class="mtk7">1</span></span>"""

def textareaHtml = textarea(
  Attribute("data-mprt", "6"),
  `class` := "inputarea monaco-mouse-cursor-text",
  wrap := "off",
  Attribute("autocorrect", "off"),
  Attribute("autocapitalize", "off"),
  Attribute("autocomplete", "off"),
  spellcheck := "false",
  Attribute("aria-label", "s dsd dasad • Untitled-1"),
  tabindex := "0",
  Attribute("role", "textbox"),
  Attribute("aria-roledescription", "editor"),
  Attribute("aria-multiline", "true"),
  Attribute("aria-haspopup", "false"),
  Attribute("aria-autocomplete", "both"),
  style := """tab-size: 36.1328px; font-family: Menlo, Monaco, "Courier New", monospace; font-weight: normal; font-size: 12px; font-feature-settings: "liga" 0, "calt" 0; font-variation-settings: normal; line-height: 18px; letter-spacing: 0px; top: 216px; left: 66px; width: 1px; height: 18px;"""
)()
def textareaHtmlSimple = textarea(
  `class` := "",
  wrap := "off",
  spellcheck := "false",
  tabindex := "0",
  Attribute("role", "textbox"),
  Attribute("aria-multiline", "true"),
  Attribute("aria-haspopup", "false"),
  Attribute("aria-autocomplete", "both"),
  style := """tab-size: 36.1328px; font-family: Menlo, Monaco, "Courier New", monospace; font-weight: normal; font-size: 12px; font-feature-settings: "liga" 0, "calt" 0; font-variation-settings: normal; line-height: 18px; letter-spacing: 0px; top: 216px; left: 66px; width: 1px; height: 18px;"""
)()

def vstring =
  """<div class="dom-input text-white block   List(s)" contenteditable="true"><div class="dom-input text-white block   List(root, app, 구인, 프론트엔드, 0, 이력서1)" contenteditable="true"><pre class="pl-1"><div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;"><div><div style="line-height: 17px;"><div><span style="color: #569cd6;">package</span> app</div><div><span style="color: #569cd6;">import</span> scala.util.chaining.*</div><div><span style="color: #569cd6;">import</span> tyrian.*</div><div><span style="color: #569cd6;">import</span> cats.effect.<span style="color: #4ec9b0;">IO</span></div><div><span style="color: #569cd6;">import</span> tyrian.<span style="color: #4ec9b0;">Html</span>.*</div><div><span style="color: #569cd6;">import</span> <span style="color: #4ec9b0;">Css</span>.*</div><div><span style="color: #569cd6;">import</span> app.parseto.common._api.*</div><div><span style="color: #569cd6;">object</span> <span style="color: #4ec9b0;">PageView</span><span style="color: #d4d4d4;">:</span></div><br><div>  <span style="color: #569cd6;">def</span> <span style="color: #dcdcaa;">view</span>(<span style="color: #9cdcfe;">model</span>: <span style="color: #4ec9b0;">Model</span>)<span style="color: #d4d4d4;">:</span> <span style="color: #4ec9b0;">Html</span>[<span style="color: #4ec9b0;">Msg</span>] <span style="color: #d4d4d4;">=</span></div><div>    div(`class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"</span><span style="color: #569cd6;">$</span><span style="color: #d4d4d4;">page</span><span style="color: #ce9178;">"</span>)(</div><div>      div(</div><div>        `class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"w-[100%]"</span></div><div>      )(</div><div>        div(p(`class` <span style="color: #d4d4d4;">:=</span> <span style="color: #ce9178;">"text-white"</span>)(model.current_jsonkey.toString())),</div><div>        div(</div><div>          `class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"dom-input text-white block   </span><span style="color: #569cd6;">${</span><span style="color: #d4d4d4;">model.current_jsonkey</span><span style="color: #569cd6;">}</span><span style="color: #ce9178;">"</span>,</div><div>          contentEditable <span style="color: #d4d4d4;">:=</span> <span style="color: #ce9178;">"true"</span></div><div>        )(</div><div>          {</div><div>            <span style="color: #6a9955;">// lazy_log()</span></div><div>            <span style="color: #4ec9b0;">List</span>(</div><div>              model</div><div>                .pipe(json2dom),</div><div>              <span style="color: #569cd6;">raw</span><span style="color: #ce9178;">"     ~~~~안녕하세요     my name is.."</span></div><div>                .pipe(string2string)</div><div>                .pipe(string2List)</div><div>                .tap(</div><div>                  log</div><div>                )</div><div>                .pipe(listString2dom),</div><div>              <span style="color: #4ec9b0;">List</span>(v)</div><div>            )(<span style="color: #b5cea8;">2</span>)</div><div>          }</div><div>        )</div><div>      )</div><div>    )</div><br></div></div></div></pre></div></div>"""

def simple =
  """<div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;"><span style="color: #569cd6;">package</span> app</div>"""

def v_string = """
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
"""

def v = div(
  style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
)(
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

def v_string_short = """
package app.parseto.common.parser
import io.circe.parser.*
"""

def v_shorts = div(
  style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
)(
  div(style := "line-height: 17px;")(
    div(
      span(style := "color: #569cd6;")("package"),
      span("app.parseto.common.parser")
    ),
    div(
      span(style := "color: #569cd6;")("import"),
      span("io.circe.parser.*")
    )
  )
)
