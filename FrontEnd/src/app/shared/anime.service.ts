import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../core/auth/models/user';
import { ApiService } from './api.service';
import { Anime } from './models/anime';





const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    Authorization: 'my-auth-token'
  })
};


@Injectable({
  providedIn: 'root'
})
export class AnimeService {




  anime!: Anime
  recommendpoint = "http://localhost:8090/anilib/anilib/recommend/"

  url = "http://localhost:8090/anilib/library"
  user = JSON.parse(localStorage.getItem('user')!) as User

  constructor(private http : HttpClient, private apiService: ApiService) { }

  recommendAnime(genre: string, rating: string) {
    return this.http.get<any>(this.recommendpoint + this.user.id + '/' + genre + '/' + rating).toPromise()
  }

  addUserAnime(name: string){
    const request = this.apiService.getAnimeId(name);
    request.subscribe(data => {
      console.log(data)
      let userAnime = {
        user: this.user,
        anime: data
      }
      console.log(userAnime)
      this.http.post(this.url, userAnime, httpOptions).subscribe()

    }) 
  }
}
