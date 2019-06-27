exports.seed = function (knex, Promise) {
    // Deletes ALL existing entries
    return knex('rol').del()
        .then(function () {
            // Inserts seed entries
            return knex('rol').insert([{
                detalle_rol: 'Administrador'
            },
            {
                detalle_rol: 'Expositor'
            }
            ]);
        });
};