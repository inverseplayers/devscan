package app
import tyrian.*
import cats.effect.IO
import tyrian.Html.*
import M.*
import Css.*
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
// import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
object JsonParser:
//   val json = """{"name":"John", "age":30, "city":"New York"}"""
  val json = """{
	a: 1, b: [2,3,4,5], c: {d: 'A', e: 'B'}, f: 'Hello', g: {h: [6,7,8], i: 9}
        }"""
  val mapper = new ObjectMapper().registerModule(DefaultScalaModule)
  val obj = mapper.readValue(json, classOf[Map[String, Any]])
  val entries = obj.toList
  val typeStr = obj.getClass.getSimpleName
  val value = typeStr match {
    case "Map"  => s"Object[{${entries.length}]"
    case "List" => s"Array[${entries.length}]"
    case _      => json
  }

  def view(model: Model): Html[Msg] = div()("")

// <div>
// 	<b>{key}</b> : <span on:click={() => expanded = !expanded}> {value} </span>
// 	{#if expanded}
// 		{#each entries as [key, value], index(index)}
// 		<svelte:self {key} json={JSON.stringify(value)}/>
// 		{/each}
// 	{/if}
// </div>
