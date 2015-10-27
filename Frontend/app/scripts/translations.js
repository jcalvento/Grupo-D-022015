function translations($translateProvider) {
  $translateProvider
    .translations('en', {
      APP_TITLE: 'SuperGoal',
      TOURNAMENT: 'Tournament',
      TEAM: 'Team',
      TEAMS: 'Teams',
      PLAYERS: 'Players',
      NEW: 'New',
      CREATE: 'Create',
      EDIT: 'Edit',
      UPDATE: 'Update',
      DELETE: 'Delete',
      POSITION: 'Position',
      NAME: 'Name',
      ACTIONS: 'Actions',
      NEW_TEAM: 'New Team',
      BACK: 'Back',
      EDIT_TEAM: 'Edit Team',
      ADD_PLAYERS: 'Add Players',
      REMOVE: 'Remove',
      ADD: 'Add',
      EDIT_PLAYER: 'Edit Player',
      NEW_PLAYER: 'New Player',
      Goalkeeper: 'Goalkeeper',
      Defender: 'Defender',
      Midfield: 'Midfield',
      Forward: 'Forward'
    })
    .translations('es', {
      APP_TITLE: 'SuperGol',
      TOURNAMENT: 'Torneo',
      TEAM: 'Equipo',
      TEAMS: 'Equipos',
      PLAYERS: 'Jugadores',
      NEW: 'Nuevo',
      CREATE: 'Crear',
      EDIT: 'Editar',
      UPDATE: 'Actualizar',
      DELETE: 'Borrar',
      POSITION: 'Posicion',
      NAME: 'Nombre',
      ACTIONS: 'Acciones',
      NEW_TEAM: 'Nuevo Equipo',
      BACK: 'Atras',
      EDIT_TEAM: 'Editar Equipo',
      ADD_PLAYERS: 'Agregar Jugadores',
      REMOVE: 'Remover',
      ADD: 'Agregar',
      EDIT_PLAYER: 'Editar Jugador',
      NEW_PLAYER: 'Nuevo Jugador',
      Goalkeeper: 'Arquero',
      Defender: 'Defensor',
      Midfield: 'Mediocampista',
      Forward: 'Delantero',
      Arquero: 'Goalkeeper',
      Defensor: 'Defender',
      Mediocampista: 'Midfield',
      Delantero: 'Forward'
    });

  $translateProvider.preferredLanguage('en');
  $translateProvider.useSanitizeValueStrategy('sanitize');
}
