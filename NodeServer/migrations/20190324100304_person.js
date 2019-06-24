exports.up = function(knex, Promise) {
    return knex.schema.createTable('persona', function(t) {

        // Primary Key
        t.bigIncrements('id_usuario');

        // Data
        t.string('nombre').notNullable();
        t.string('email').notNullable().unique();

    })

};

exports.down = function(knex, Promise) {
    return knex.schema.dropTableIfExists('persona');
};