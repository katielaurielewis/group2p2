import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { RouterModule, ROUTES } from '@angular/router';
import { Routes } from '@angular/router';

import { CarouselModule } from 'ngx-owl-carousel-o';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './core/navbar/navbar.component';
import { RecommenderComponent } from './features/recommender/recommender.component';
import { LibraryComponent } from './features/library/library.component';
import { UserDashboardComponent } from './features/user-dashboard/user-dashboard.component';
import { CoreModule } from './core/core.module';
import { AuthInterceptor } from './core/auth/services/auth.interceptor';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    RecommenderComponent,
    LibraryComponent,
    UserDashboardComponent,
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    CoreModule,
    HttpClientModule,
    RouterModule,
    CarouselModule
  ],
  
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
