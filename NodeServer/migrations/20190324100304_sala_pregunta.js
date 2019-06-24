exports.up = function(knex, Promise) {
    return knex.schema.createTable('sala_pregunta', function(t) {

        // Primary Key
        t.bigIncrements('id');

        // Data
        t.integer('id_sala').notNullable();
        t.integer('id_pregunta').notNullable();

    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('sala_pregunta');
};