;
let config = require('../knexfile')
let env = 'development'
let db = require('knex')(config[env])

let allData = (req, res) => {
    let tabla = req.query.tabla
    let campo = req.query.campo
    db.select(campo).from(tabla)
        .then(resultado => {
            return res.status(200).json({
                ok: true,
                datos: resultado,
                mensaje: `Existen ${resultado.length} regisros en la consulta`
            })
        })
        .catch((error) => {
            return res.status(500).json({
                ok: false,
                datos: null,
                mensaje: `Error del servidor: ${error}`
            })
        })
}

let get = (req, res) => {
    return res.status(200).json({
        mensaje: "la prueba es OK21"
    })
}

let insertData = (req, res) => {
    let tabla = req.body.tabla
    let datos = req.body.datos
    console.log(req.body)
    console.log(tabla);
    console.log(datos);
    const qu = db.insert(datos).into(tabla); //Insertar
    //knex('books').insert({title: 'Slaughterhouse Five'})
    qu.then(resultado => {
            console.log(resultado);
            return res.status(200).json({
                ok: true,
                datos: resultado,
                mensaje: `Existen ${resultado.length} regisros en la consulta`
            })
        })
        .catch((error) => {
            return res.status(500).json({
                ok: false,
                datos: datos,
                mensaje: `Error del servidor: ${error}` + tabla
            })
        })
}

module.exports = {
    allData,
    get,
    insertData
}