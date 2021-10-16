import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';

import { Observable, throwError } from 'rxjs';
import {catchError, retry} from 'rxjs/operators'

import { User } from './models/user';

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

  url: string = "http://localhost:3000/posts"
  constructor(
    private http: HttpClient,
    public router: Router,
  ) { }

  register(user: any): Observable<any> {
    return this.http.post<any>(this.url, user, httpOptions)
  }

}
