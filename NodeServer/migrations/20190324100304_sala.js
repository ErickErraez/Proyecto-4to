exports.up = function(knex, Promise) {
    return knex.schema.createTable('sala', function(t) {

        // Primary Key
        t.bigIncrements('id');

        // Data
        t.string('nombre_sala').notNullable();
        t.string('tema_sala').notNullable();
        t.date('fechaInicio_sala').notNullable();
        t.date('fechaFin_sala').notNullable();
        t.integer('capacidad_sala').notNullable();
        t.string('link_sala').notNullable();
        t.integer('id_expositor').notNullable();


    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('sala');
};