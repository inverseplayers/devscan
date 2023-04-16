<script>
    export let json
    export let key = "JSON"
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
    </script>
    
    <div>
        <b>{key}</b> : <span on:click={() => expanded = !expanded}> {value} </span>
        {#if expanded}
            {#each entries as [key, value], index(index)}
            <svelte:self {key} json={JSON.stringify(value)}/>
            {/each}
        {/if}
    </div>
    
    <style>
        div {margin: 10px 0 0 14px}
    </style>