import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../core/auth/models/user';
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

  endpoint = "http://localhost:8090/anilib/anilib/recommend/"
  user = JSON.parse(localStorage.getItem('user')!) as User

  constructor(private http : HttpClient) { }

  // searchAnime(name: String){
  //   JikanTS.Search.search("{name}", "anime", 1, {limit: 1}).then((b: any) => console.log(b))
  // }

  recommendAnime(genre: string, rating: string) {
    return this.http.get<any>(this.endpoint + this.user.id + '/' + genre + '/' + rating).toPromise()
  }

}
