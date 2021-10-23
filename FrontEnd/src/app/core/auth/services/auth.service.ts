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

  url: string = "http://localhost:8090/anilib/"
  tokenKey: string = 'access_token'
  constructor(
    private http: HttpClient,
    public router: Router,
  ) { }

  register(user: User): Observable<User> {
    return this.http.post<User>(this.url + "user/register", user, httpOptions)
      .pipe(
        catchError(this.handleError)
      )
  }

  login(credentials: string) {
    this.http.post<any>(this.url + "login", credentials)
      .subscribe(async (res : any) => {
        this.setToken(res.token)
      })
  }

  async setToken(token: string) {
    localStorage.setItem(this.tokenKey, token)
  }

  getToken(){
    return localStorage.getItem(this.tokenKey)
  }

  get IsLoggedIn(){
    let authToken = localStorage.getItem(this.tokenKey);
    console.log(authToken);
    return authToken !== null && authToken != 'undefined';
  }

  logout(){
    localStorage.clear();
    this.router.navigate(['login']);
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
