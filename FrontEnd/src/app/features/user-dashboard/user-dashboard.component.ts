import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  user: User = JSON.parse(localStorage.getItem('user')!)
  username = this.user.username;
  friend = "";
}
