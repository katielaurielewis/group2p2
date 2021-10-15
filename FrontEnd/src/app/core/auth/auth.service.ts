import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import {catchError, retry} from 'rxjs/operators'

import { User } from './models/user';

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  endpoint: string = "http://localhost:4200/login"
  headers = new HttpHeaders().set('Content-Type', 'application/json' );
  currentUser = {}

  constructor(
    private http: HttpClient,
    public router: Router
  ) { }

  login(user: User): Observable<User> {
    return this.http.post<User>(this.endpoint, user)
  }
}
