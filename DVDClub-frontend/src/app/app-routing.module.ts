import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRegistrationComponent } from './dvdclub/user-registration/user-registration.component';
import { UserLoginComponent } from './dvdclub/user-login/user-login.component';
import { AdminPageComponent } from './dvdclub/admin-page/admin-page.component';
import { ActorsComponent } from './dvdclub/actors/actors.component';
import { ActorAddComponent } from './dvdclub/actor-add/actor-add.component';
import { DirectorsComponent } from './dvdclub/directors/directors.component';
import { DirectorAddComponent } from './dvdclub/director-add/director-add.component';
import { FilmstudiosComponent } from './dvdclub/filmstudios/filmstudios.component';
import { FilmstudioAddComponent } from './dvdclub/filmstudio-add/filmstudio-add.component';
import { MarketplacesComponent } from './dvdclub/marketplaces/marketplaces.component';
import { MarketplaceAddComponent } from './dvdclub/marketplace-add/marketplace-add.component';
import { FilmsComponent } from './dvdclub/films/films.component';
import { FilmAddComponent } from './dvdclub/film-add/film-add.component';
import { ManagersComponent } from './dvdclub/managers/managers.component';
import { ManagerAddComponent } from './dvdclub/manager-add/manager-add.component';
import { ActorEditComponent } from './dvdclub/actor-edit/actor-edit.component';
import { DirectorEditComponent } from './dvdclub/director-edit/director-edit.component';
import { FilmstudioEditComponent } from './dvdclub/filmstudio-edit/filmstudio-edit.component';
import { FilmEditComponent } from './dvdclub/film-edit/film-edit.component';
import { MarketplaceEditComponent } from './dvdclub/marketplace-edit/marketplace-edit.component';
import { NewsComponent } from './dvdclub/news/news.component';
import { NewsAddComponent } from './dvdclub/news-add/news-add.component';
import { NewsEditComponent } from './dvdclub/news-edit/news-edit.component';
import { DvdsManagerComponent } from './dvdclub/dvds-manager/dvds-manager.component';
import { SpecialoffersManagerComponent } from './dvdclub/specialoffers-manager/specialoffers-manager.component';
import { DvdAddComponent } from './dvdclub/dvd-add/dvd-add.component';
import { DvdEditComponent } from './dvdclub/dvd-edit/dvd-edit.component';
import { SpecialofferAddComponent } from './dvdclub/specialoffer-add/specialoffer-add.component';
import { SpecialofferEditComponent } from './dvdclub/specialoffer-edit/specialoffer-edit.component';
import { MarketplacesCustomerComponent } from './dvdclub/marketplaces-customer/marketplaces-customer.component';
import { DvdsCustomerComponent } from './dvdclub/dvds-customer/dvds-customer.component';
import { FilmViewComponent } from './dvdclub/film-view/film-view.component';
import { RatingAddComponent } from './dvdclub/rating-add/rating-add.component';

const routes: Routes = [
  { path: 'user-registration', component: UserRegistrationComponent },
  { path: 'user-login', component: UserLoginComponent },
  { path: 'admin-page', component: AdminPageComponent },
  { path: 'actors', component: ActorsComponent },
  { path: 'actor-add', component: ActorAddComponent },
  { path: 'directors', component: DirectorsComponent },
  { path: 'director-add', component: DirectorAddComponent },
  { path: 'filmstudios', component: FilmstudiosComponent },
  { path: 'filmstudio-add', component: FilmstudioAddComponent },
  { path: 'marketplaces', component: MarketplacesComponent },
  { path: 'marketplace-add', component: MarketplaceAddComponent },
  { path: 'films', component: FilmsComponent },
  { path: 'film-add', component: FilmAddComponent },
  { path: 'managers', component: ManagersComponent },
  { path: 'manager-add', component: ManagerAddComponent },
  { path: 'actor-edit', component: ActorEditComponent },
  { path: 'director-edit', component: DirectorEditComponent },
  { path: 'filmstudio-edit', component: FilmstudioEditComponent },
  { path: 'film-edit', component: FilmEditComponent },
  { path: 'marketplace-edit', component: MarketplaceEditComponent },
  { path: 'news', component: NewsComponent },
  { path: 'news-add', component: NewsAddComponent },
  { path: 'news-edit', component: NewsEditComponent },
  { path: 'dvds-manager', component: DvdsManagerComponent },
  { path: 'specialoffers-manager', component: SpecialoffersManagerComponent },
  { path: 'dvd-add', component: DvdAddComponent },
  { path: 'dvd-edit', component: DvdEditComponent },
  { path: 'specialoffer-add', component: SpecialofferAddComponent },
  { path: 'specialoffer-edit', component: SpecialofferEditComponent },
  { path: 'marketplaces-customer', component: MarketplacesCustomerComponent },
  { path: 'dvds-customer', component: DvdsCustomerComponent },
  { path: 'film-view', component: FilmViewComponent },
  { path: 'rating-add', component: RatingAddComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
