import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';
import { HttpClient } from '@angular/common/http';
import { Anime } from 'src/app/shared/models/anime';



@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {

  endpoint = "http://localhost:8090/anilib/library/user/"

  username = '';
  userId = -1;
  anime: any;
  constructor(private http: HttpClient) { }

  ngOnInit(): void {
    let user = JSON.parse(localStorage.getItem('user')!) as User
    this.username = user.username
    this.http.get<any>(this.endpoint + user.id)
    .subscribe((res: Anime[]) => {
      this.anime = res;
    })
  }

}
