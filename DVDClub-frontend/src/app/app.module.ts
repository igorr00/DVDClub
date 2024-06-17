import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatDialogModule } from '@angular/material/dialog';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatDividerModule } from '@angular/material/divider';
import { MatStepperModule } from '@angular/material/stepper';
import { MatRadioModule } from '@angular/material/radio';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatIconModule } from '@angular/material/icon';
import { MatTooltipModule } from '@angular/material/tooltip';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatSidenavModule } from '@angular/material/sidenav'

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

@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    UserLoginComponent,
    AdminPageComponent,
    ActorsComponent,
    ActorAddComponent,
    DirectorsComponent,
    DirectorAddComponent,
    FilmstudiosComponent,
    FilmstudioAddComponent,
    MarketplacesComponent,
    MarketplaceAddComponent,
    FilmsComponent,
    FilmAddComponent,
    ManagersComponent,
    ManagerAddComponent,
    ActorEditComponent,
    DirectorEditComponent,
    FilmstudioEditComponent,
    FilmEditComponent,
    MarketplaceEditComponent,
    NewsComponent,
    NewsAddComponent,
    NewsEditComponent,
    DvdsManagerComponent,
    SpecialoffersManagerComponent
  ],
  imports: [
    CommonModule,
    HttpClientModule,
    BrowserModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot(),
    AppRoutingModule,
    MatButtonModule,
    MatFormFieldModule,
    MatIconModule,
    MatTooltipModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatTableModule,
    FormsModule,
    ReactiveFormsModule,
    MatCheckboxModule,
    MatSlideToggleModule,
    MatDialogModule,
    MatProgressSpinnerModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatPaginatorModule,
    MatDividerModule,
    MatStepperModule,
    MatRadioModule,
    MatGridListModule,
    MatSidenavModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
