exports.up = function(knex, Promise) {
    return knex.schema.createTable('rol', function(t) {

        // Primary Key
        t.bigIncrements('id');

        // Data
        t.string('detalle_rol').notNullable();


    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('rol');
};