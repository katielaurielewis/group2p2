import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';
import { AnimeService } from 'src/app/shared/anime.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {

  constructor(private animeService:AnimeService) { }

  ngOnInit(): void {
    this.animeService.addUserAnime("super milk chan")
  }

  user: User = JSON.parse(localStorage.getItem('user')!)
  username = this.user.username;
  friend = ""
}
