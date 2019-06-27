;
const express = require('express')
let api = express.Router(),
    dataControl = require('../controles/allData')

api.get('/getData', dataControl.allData)
api.get('/get', dataControl.get)
api.post('/saveData', dataControl.insertData)
api.put('/updateData', dataControl.updateData)
api.delete('/deleteData', dataControl.deleteData)
api.post('/saveDataArray', dataControl.insertArrays)

module.exports = api