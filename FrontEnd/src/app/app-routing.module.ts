import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LibraryComponent } from './features/library/library.component';
import { UserDashboardComponent } from './features/user-dashboard/user-dashboard.component';


const routes: Routes = [
  {path: 'dashboard', component:UserDashboardComponent},
  {path: 'library', component:LibraryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
