import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserRegistrationComponent } from './dvdclub/user-registration/user-registration.component';
import { UserLoginComponent } from './dvdclub/user-login/user-login.component';
import { AdminPageComponent } from './dvdclub/admin-page/admin-page.component';

const routes: Routes = [
  { path: 'user-registration', component: UserRegistrationComponent },
  { path: 'user-login', component:UserLoginComponent },
  { path: 'admin-page', component:AdminPageComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
