import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/services/auth.service';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  username = new FormControl('');
  loggedIn = this.authService.IsLoggedIn

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }
  searchByUser(){}

  logout(){
    this.authService.logout
  }
}
