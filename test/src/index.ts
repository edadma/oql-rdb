import {OQL_MEM} from '@vinctus/oql-mem'

//
;(async () => {
  const db = new OQL_MEM(
    `
    entity x {
      *id: integer
       a: integer
    }
    `
  )

  await db.create()

  const x = db.entity('x')

  x.insert({id: 1, a: 3})

  const data = await db.queryMany('x')

  console.log(data)

  console.log(await db.raw('SELECT * FROM x'))
})()
