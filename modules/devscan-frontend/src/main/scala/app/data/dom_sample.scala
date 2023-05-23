package app
import tyrian.*
import tyrian.Html.*

// vscode =>  복붙 html => 스페이스 소실발생  => converter
// https://simerplaha.github.io/html-to-scala-converter/

def vstring =
  """<div class="dom-input text-white block   List(s)" contenteditable="true"><div class="dom-input text-white block   List(root, app, 구인, 프론트엔드, 0, 이력서1)" contenteditable="true"><pre class="pl-1"><div style="color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, &quot;Courier New&quot;, monospace; font-size: 11px; line-height: 17px;"><div><div style="line-height: 17px;"><div><span style="color: #569cd6;">package</span> app</div><div><span style="color: #569cd6;">import</span> scala.util.chaining.*</div><div><span style="color: #569cd6;">import</span> tyrian.*</div><div><span style="color: #569cd6;">import</span> cats.effect.<span style="color: #4ec9b0;">IO</span></div><div><span style="color: #569cd6;">import</span> tyrian.<span style="color: #4ec9b0;">Html</span>.*</div><div><span style="color: #569cd6;">import</span> <span style="color: #4ec9b0;">Css</span>.*</div><div><span style="color: #569cd6;">import</span> app.parseto.common._api.*</div><div><span style="color: #569cd6;">object</span> <span style="color: #4ec9b0;">PageView</span><span style="color: #d4d4d4;">:</span></div><br><div>  <span style="color: #569cd6;">def</span> <span style="color: #dcdcaa;">view</span>(<span style="color: #9cdcfe;">model</span>: <span style="color: #4ec9b0;">Model</span>)<span style="color: #d4d4d4;">:</span> <span style="color: #4ec9b0;">Html</span>[<span style="color: #4ec9b0;">Msg</span>] <span style="color: #d4d4d4;">=</span></div><div>    div(`class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"</span><span style="color: #569cd6;">$</span><span style="color: #d4d4d4;">page</span><span style="color: #ce9178;">"</span>)(</div><div>      div(</div><div>        `class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"w-[100%]"</span></div><div>      )(</div><div>        div(p(`class` <span style="color: #d4d4d4;">:=</span> <span style="color: #ce9178;">"text-white"</span>)(model.current_jsonkey.toString())),</div><div>        div(</div><div>          `class` <span style="color: #d4d4d4;">:=</span> <span style="color: #569cd6;">s</span><span style="color: #ce9178;">"dom-input text-white block   </span><span style="color: #569cd6;">${</span><span style="color: #d4d4d4;">model.current_jsonkey</span><span style="color: #569cd6;">}</span><span style="color: #ce9178;">"</span>,</div><div>          contentEditable <span style="color: #d4d4d4;">:=</span> <span style="color: #ce9178;">"true"</span></div><div>        )(</div><div>          {</div><div>            <span style="color: #6a9955;">// lazy_log()</span></div><div>            <span style="color: #4ec9b0;">List</span>(</div><div>              model</div><div>                .pipe(json2dom),</div><div>              <span style="color: #569cd6;">raw</span><span style="color: #ce9178;">"     ~~~~안녕하세요     my name is.."</span></div><div>                .pipe(string2string)</div><div>                .pipe(string2List)</div><div>                .tap(</div><div>                  log</div><div>                )</div><div>                .pipe(listString2dom),</div><div>              <span style="color: #4ec9b0;">List</span>(v)</div><div>            )(<span style="color: #b5cea8;">2</span>)</div><div>          }</div><div>        )</div><div>      )</div><div>    )</div><br></div></div></div></pre></div></div>"""

def v = div(
  `class` := "dom-input text-white block   List(root, app, 구인, 프론트엔드, 0, 이력서1)",
  contenteditable := "true"
)(
  pre(`class` := "pl-1")(
    div(
      style := """color: rgb(204, 204, 204); background-color: rgb(31, 31, 31); font-family: Menlo, Monaco, "Courier New", monospace; font-size: 11px; line-height: 17px;"""
    )(
      div(span(style := "color: #569cd6;")("package"), div("app")),
      div(
        span(style := "color: #569cd6;")("import"),
        span("scala.util.chaining.*")
      ),
      div(span(style := "color: #569cd6;")("import"), span("tyrian.*")),
      div(
        span(style := "color: #569cd6;")("import"),
        span("cats.effect."),
        span(style := "color: #4ec9b0;")("IO")
      ),
      div(
        span(style := "color: #569cd6;")("import"),
        span("tyrian."),
        span(style := "color: #4ec9b0;")("Html"),
        span(".*")
      ),
      div(
        span(style := "color: #569cd6;")("import"),
        span(style := "color: #4ec9b0;")("Css"),
        span(".*")
      ),
      div(
        span(style := "color: #569cd6;")("import"),
        span("app.parseto.common._api.*")
      ),
      div(
        span(style := "color: #569cd6;")("object"),
        span(style := "color: #4ec9b0;")("PageView"),
        span(style := "color: #d4d4d4;")(":")
      ),
      br,
      div(
        span(style := "color: #569cd6;")(span("def")),
        span(style := "color: #dcdcaa;")(span("view")),
        span("("),
        span(style := "color: #9cdcfe;")(span("model")),
        span(":"),
        span(style := "color: #4ec9b0;")(span("Model")),
        span(")"),
        span(style := "color: #d4d4d4;")(span(":")),
        span(style := "color: #4ec9b0;")(span("Html")),
        span("["),
        span(style := "color: #4ec9b0;")(span("Msg")),
        span("]"),
        span(style := "color: #d4d4d4;")(span("="))
      ),
      div(
        span("div(`class`"),
        span(style := "color: #d4d4d4;")(":="),
        span(style := "color: #569cd6;")("s"),
        span(style := "color: #ce9178;")("""""""),
        span(style := "color: #569cd6;")("$"),
        span(style := "color: #d4d4d4;")("page"),
        span(style := "color: #ce9178;")("""""""),
        span(")(")
      ),
      div("div("),
      div(
        span("`class`"),
        span(style := "color: #d4d4d4;")(":="),
        span(style := "color: #569cd6;")("s"),
        span(style := "color: #ce9178;")(""""w-[100%]"""")
      ),
      div(")("),
      div(
        span("div(p(`class`"),
        span(style := "color: #d4d4d4;")(":="),
        span(style := "color: #ce9178;")(""""text-white""""),
        span(")(model.current_jsonkey.toString())),")
      ),
      div("div("),
      div(
        span("`class`"),
        span(style := "color: #d4d4d4;")(":="),
        span(style := "color: #569cd6;")("s"),
        span(style := "color: #ce9178;")(""""dom-input text-white block"""),
        span(style := "color: #569cd6;")("${"),
        span(style := "color: #d4d4d4;")("model.current_jsonkey"),
        span(style := "color: #569cd6;")("}"),
        span(style := "color: #ce9178;")("""""""),
        span(",")
      ),
      div(
        span("          contentEditable "),
        span(style := "color: #d4d4d4;")(":="),
        span(style := "color: #ce9178;")(""""true"""")
      ),
      div(")("),
      div("{"),
      div(span(style := "color: #6a9955;")("// lazy_log()")),
      div(span(style := "color: #4ec9b0;")("List"), span("(")),
      div("model"),
      div(".pipe(json2dom),"),
      div(
        span(style := "color: #569cd6;")("raw"),
        span(style := "color: #ce9178;")(
          """"     ~~~~안녕하세요     my name is..""""
        )
      ),
      div(".pipe(string2string)"),
      div(".pipe(string2List)"),
      div(".tap("),
      div("log"),
      div(")"),
      div(".pipe(listString2dom)"),
      div(span(")("), span(style := "color: #b5cea8;")("0"), span(")")),
      div("}"),
      div(")"),
      div(")"),
      div(")"),
      br
    )
  )
)
