import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/services/auth.service';
import { FormControl } from '@angular/forms';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  
  isLoggedIn!: Observable<boolean>;
  username = new FormControl('');
 
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.isLoggedIn = this.authService.IsLoggedIn;
  }
  searchByUser(){}

  logout(){
    this.authService.logout()
  }
}
