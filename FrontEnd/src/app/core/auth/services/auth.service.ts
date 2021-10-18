import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import { shareReplay, retry, catchError} from 'rxjs/operators'

import { User } from '../models/user';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    Authorization: 'my-auth-token'
  })
};

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  url: string = "http://localhost:8090/"
  constructor(
    private http: HttpClient,
    public router: Router,
  ) { }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.url + "register", user, httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  login(user : User){
    return this.http.post<User>(this.url + "login", user)
      .subscribe((res : any) => {
        localStorage.setItem('access_token', res.token)
      }) 
  }

  getToken(){
    return localStorage.getItem("access_token")
  }

  get IsLoggedIn(){
    let authToken = localStorage.getItem('access_token');
    return (authToken !== null) ? true : false;
  }

  logout(){
    let removeToken = localStorage.getItem('access_token');
    if (removeToken == null) {
      this.router.navigate(['login']);
    }
  }

  handleError(error: HttpErrorResponse){
    let msg = '';
    if (error.error instanceof ErrorEvent){
      // Client-side error
      msg = error.error.message
    } else {
      // Server-side error
      msg = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(msg);
  }

}
