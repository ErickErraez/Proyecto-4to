exports.seed = function (knex, Promise) {
    // Deletes ALL existing entries
    return knex('expositor').del()
        .then(function () {
            // Inserts seed entries
            return knex('expositor').insert([{
                titulo_expositor: 'Ing. Sistemas',
                institucion_expositor: 'Universidad Central'
            },
            {
                titulo_expositor: 'Lic. Agronomía',
                institucion_expositor: 'Ministerio de Agricultura'
            },
            {
                titulo_expositor: 'Ing. Ambiental',
                institucion_expositor: 'INIAP'
            }
            ]);
        });
};