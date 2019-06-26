exports.up = function(knex, Promise) {
    return knex.schema.createTable('usuario_rol', function(t) {

        // Primary Key
        t.bigIncrements('id');

        // Data
        t.integer('id_persona').notNullable();
        t.integer('id_rol').notNullable();

    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('usuario_rol');
};