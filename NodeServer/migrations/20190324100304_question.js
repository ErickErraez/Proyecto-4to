exports.up = function(knex, Promise) {
    return knex.schema.createTable('preguntas', function(t) {

        // Primary Key
        t.bigIncrements('id_preguntas');

        // Data
        t.string('detalle').notNullable();
        t.string('estado').notNullable();
        t.integer('id_persona').notNullable();
    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('preguntas');
};