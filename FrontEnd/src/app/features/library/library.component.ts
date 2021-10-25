import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';
import { HttpClient } from '@angular/common/http';
import { Anime } from 'src/app/shared/models/anime';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  userEndpoint: string = "http://localhost:8090/anilib/user/";

  user!: User;
  anime: any;
  constructor(private http: HttpClient, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    // read optional path parameter to read another user's library
    // if not present, get current logged in user's library
    var pathUsername = this.route.snapshot.params['username']
    if(pathUsername) {
      this.http.get<any>(this.userEndpoint + pathUsername)
        .subscribe((res: User) => {
          this.user = res;
          this.loadUserData()
        })
    } else {
      this.user = JSON.parse(localStorage.getItem('user')!) as User
      this.loadUserData()
    }
  }

  loadUserData() {
    // determine which anime to display based on the route
    // /library route == unwatched anime == status 1 | /watched route == watched anime == status 2
    var statusId = this.router.url.startsWith('/library') ? 1 : 2
    console.log(statusId)
    this.http.get<any>(this.getUserDataURL(statusId))
    .subscribe((res: Anime[]) => {
      this.anime = res;
    })
  }

  getUserDataURL(statusId: number) {
    return 'http://localhost:8090/anilib/library/user/' + this.user.id + '/status/' + statusId
  }
}
