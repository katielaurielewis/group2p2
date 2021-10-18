import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CredentialsService {
  username = '';
  password = '';
  constructor() { }

  getUsername() {
    return this.username;
  }

  setUsername(username: string) {
    this.username = username;
  }
}
