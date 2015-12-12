Rails.application.routes.draw do
  devise_for :users
  # The priority is based upon order of creation: first created -> highest priority.
  # See how all your routes lay out with "rake routes".

  # You can have the root of your site routed with "root"
  # root 'welcome#index'

  # Example of regular route:
  #   get 'products/:id' => 'catalog#view'

  # Example of named route that can be invoked with purchase_url(id: product.id)
  #   get 'products/:id/purchase' => 'catalog#purchase', as: :purchase

  # Example resource route (maps HTTP verbs to controller actions automatically):
  #   resources :products

  # Example resource route with options:
  #   resources :products do
  #     member do
  #       get 'short'
  #       post 'toggle'
  #     end
  #
  #     collection do
  #       get 'sold'
  #     end
  #   end

  # Example resource route with sub-resources:
  #   resources :products do
  #     resources :comments, :sales
  #     resource :seller
  #   end

  # Example resource route with more complex sub-resources:
  #   resources :products do
  #     resources :comments
  #     resources :sales do
  #       get 'recent', on: :collection
  #     end
  #   end

  # Example resource route with concerns:
  #   concern :toggleable do
  #     post 'toggle'
  #   end
  #   resources :posts, concerns: :toggleable
  #   resources :photos, concerns: :toggleable

  # Example resource route within a namespace:
  #   namespace :admin do
  #     # Directs /admin/products/* to Admin::ProductsController
  #     # (app/controllers/admin/products_controller.rb)
  #     resources :products
  #   end

  resources :players, only: [:index, :edit, :update, :create, :destroy], defaults: {format: :json}
  match '/players' => 'players#options', via: :options
  match '/players/:id' => 'teams#options', via: :options

  resources :teams, only: [:index, :edit, :update, :create, :destroy], defaults: {format: :json}
  get '/teams/:id/players' => 'teams#available_players'
  post '/teams/:id/add_player' => 'teams#add_player'
  post '/teams/:id/remove_player' => 'teams#remove_player'

  match '/teams' => 'teams#options', via: :options
  match '/teams/:id' => 'teams#options', via: :options
  match '/teams/:id/players' => 'teams#options', via: :options
  match '/teams/:id/add_player' => 'teams#options', via: :options
  match '/teams/:id/remove_player' => 'teams#options', via: :options

  resources :tournaments, only: [:index, :edit, :update, :create, :destroy], defaults: {format: :json}
  get  '/tournaments/:id/teams' => 'tournaments#available_teams'
  post '/tournaments/:id/add_team' => 'tournaments#add_team'
  post '/tournaments/:id/remove_team' => 'tournaments#remove_team'
  get  '/tournaments/:id/generate_fixture' => 'tournaments#generate_fixture'
  get  '/tournaments/:id/fixture' => 'tournaments#fixture'
  get  '/tournaments/:date_match_id/date_match_goals' => 'tournaments#date_match_goals'
  post '/tournaments/:date_match_id/date_match_goals' => 'tournaments#add_date_match_goal'
  post '/tournaments/:date_match_id/end_date_match' => 'tournaments#end_date_match'
  get  '/tournaments/:date_match_id/date_match_details' => 'tournaments#date_match_details'

  match '/tournaments' => 'tournaments#options', via: :options
  match '/tournaments/:id' => 'tournaments#options', via: :options
  match '/tournaments/:id/teams' => 'tournaments#options', via: :options
  match '/tournaments/:id/add_team' => 'tournaments#options', via: :options
  match '/tournaments/:id/remove_team' => 'tournaments#options', via: :options
  match '/tournaments/:id/generate_fixture' => 'tournaments#options', via: :options
  match '/tournaments/:id/fixture' => 'tournaments#options', via: :options
  match '/tournaments/:date_match_id/date_match_goals' => 'tournaments#options', via: :options
  match '/tournaments/:date_match_id/end_date_match' => 'tournaments#options', via: :options
  match '/tournaments/:date_match_id/date_match_details' => 'tournaments#options', via: :options

end
