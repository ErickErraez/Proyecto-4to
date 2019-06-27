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
    const qu = db.insert(datos[i]).into(tabla);
    qu.then(resultado => {
            console.log(resultado);
            return res.status(200).json({
                ok: true,
                datos: resultado,
                mensaje: `Registro Creado con Exito`
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

let insertArrays = (req, res) => {
    let tabla = req.body.tabla
    let datos = req.body.datos
    for (let i = 0; i < datos.length; i++) {
        const qu = db.insert(datos[i]).into(tabla);
        qu.then(resultado => {
                console.log(resultado);
                return res.status(200).json({
                    ok: true,
                    datos: resultado,
                    mensaje: `Registro Creado con Exito`
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
}

let updateData = (req, res) => {
    let tabla = req.body.tabla
    let datos = req.body.datos
    const qu = db(tabla).where("id", datos.id).update(datos)
    qu.then(resultado => {
            return res.status(200).json({
                ok: true,
                datos: resultado,
                mensaje: `Se actualizo correctamente el registro`
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

let deleteData = (req, res) => {
    let tabla = req.body.tabla
    let datos = req.body.datos
    const qu = db(tabla).where("id", datos.id).delete()
    qu.then(resultado => {
            return res.status(200).json({
                ok: true,
                datos: resultado,
                mensaje: `Se Borro con exito`
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
    insertData,
    updateData,
    insertArrays,
    deleteData
}