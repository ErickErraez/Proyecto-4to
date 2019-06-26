exports.seed = function(knex, Promise) {
    // Deletes ALL existing entries
    return knex('preguntas').del()
        .then(function() {
            // Inserts seed entries
            return knex('preguntas').insert([{
                    detalle: '¿Cómo Funciona?',
                    estado: 'Activo',
                    id_persona: 1,
                },
                {
                    detalle: '¿Cuál sería el costo?',
                    estado: 'Activo',
                    id_persona: 1,
                }
            ]);
        });
};