import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {UsersListComponent} from "./users-list/users-list.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: '/usersList',
    pathMatch: 'full'
  }, {
    path: 'usersList',
    component: UsersListComponent,
    data: {title: 'Users List'}
  }, {
    path: 'patient/:id',
    component: UserProfileComponent,
    data: {title: 'Patient Profile'}
  }
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
