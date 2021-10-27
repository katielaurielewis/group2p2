import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';
import { HttpClient } from '@angular/common/http';
import { Anime } from 'src/app/shared/models/anime';
import { ActivatedRoute, Router } from '@angular/router';
import { Review } from 'src/app/shared/models/review';

@Component({
  selector: 'app-library',
  templateUrl: './library.component.html',
  styleUrls: ['./library.component.css']
})
export class LibraryComponent implements OnInit {
  userEndpoint: string = "http://localhost:8090/anilib/user/";
  reviewEndpoint: string = "http://localhost:8090/anilib/review/user/"

  user!: User;
  anime!: Anime[];
  unwatched!: boolean;
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
      this.unwatched = this.router.url.startsWith('/library')
      this.loadUserData()
    }
  }

  loadUserData() {
    // determine which anime to display based on the route
    // /library route == unwatched anime == status 1 | /watched route == watched anime == status 2
    let statusId = this.unwatched ? 1 : 2
    console.log(statusId)
    this.http.get<any>(this.getUserDataURL(statusId))
    .subscribe((res: Anime[]) => {
      this.anime = res;
      if(statusId = 2) {
        this.http.get<any>(this.reviewEndpoint + this.user.id)
          .subscribe((res: Review[]) => {
            res.forEach((it) => {
              let reviewedAnime = this.anime.find((an) => an.id == it.animeId)
              if(reviewedAnime) {
                reviewedAnime!.review = it
              }
            })
            console.log(this.anime)
          })
      }
    })
  }

  getUserDataURL(statusId: number) {
    return 'http://localhost:8090/anilib/library/user/' + this.user.id + '/status/' + statusId
  }
}
