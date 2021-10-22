import { Component, OnInit } from '@angular/core';
import { CredentialsService } from 'src/app/credentials.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private credentialsService: CredentialsService) { }

  ngOnInit(): void {
  }

  username = this.credentialsService.getUsername();
  friend = "";
}
