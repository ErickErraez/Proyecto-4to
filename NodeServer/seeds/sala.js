exports.seed = function(knex, Promise) {
    // Deletes ALL existing entries
    return knex('sala').del()
        .then(function() {
            // Inserts seed entries
            return knex('sala').insert([{
                nombre_sala: 'Software 1',
                tema_sala: 'Evolución del Software',
                fechaInicio_sala: '2019-06-24',
                fechaFin_sala: '2019-06-25',
                capacidad_sala: 40,
                link_sala: 'www.software1.com/evolucion_del_software',
                id_expositor: 1,
            }]);
        });
};