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
  { path: 'marketplace-add', component: MarketplaceAddComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
