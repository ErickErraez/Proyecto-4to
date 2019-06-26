exports.seed = function(knex, Promise) {
    // Deletes ALL existing entries
    return knex('persona').del()
        .then(function() {
            // Inserts seed entries
            return knex('persona').insert([{
                    nombre: 'Luis Fernandez',
                    email: 'luchof@gmail.com'
                },
                {
                    nombre: 'Hector Chavez',
                    email: 'hchavez@gmail.com'
                },
                {
                    nombre: 'Luis Fernandez',
                    email: 'luchof2@gmail.com'
                }
            ]);
        });
};