exports.up = function(knex, Promise) {
    return knex.schema.createTable('expositor', function(t) {

        // Primary Key
        t.bigIncrements('id');

        // Data
        t.string('titulo_expositor').notNullable();
        t.string('institucion_expositor').notNullable();


    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('expositor');
};