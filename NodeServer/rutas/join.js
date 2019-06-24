;
const express = require('express')
let api = express.Router(),
    dataControl = require('../controles/allData')

api.get('/getData', dataControl.allData)
api.get('/get', dataControl.get)
api.post('/getData', dataControl.insertData)

module.exports = api