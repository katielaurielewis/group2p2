import { HttpClient, HttpErrorResponse, HttpHeaders, HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAnime } from '../core/auth/models/user-anime';
import { AuthService } from '../core/auth/services/auth.service';
import { Observable, throwError, forkJoin } from 'rxjs';
import { catchError, retry, take } from 'rxjs/operators';
import { Anime } from './models/anime';
import { User } from '../core/auth/models/user';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    Authorization: localStorage.getItem('access_token') as string
  })
};
@Injectable({
  providedIn: 'root'
})
export class ApiService {


  user_id: string = JSON.parse(localStorage.getItem("user")!).id
  anime_id!: string;
  anime!: Anime
  user!: User
  token = this.authService.getToken() as string
  url: string = "https://api.jikan.moe/v3/anime/20"

  constructor(private http: HttpClient, private authService: AuthService, handler: HttpBackend) {
    this.http = new HttpClient(handler)
   }

  async setAnimeId(name: string){
    const reqUrl = "https://api.jikan.moe/v3/search/anime?q=" + name + "&page=1&limit=1"
    const response = await (await fetch(reqUrl)).json()
    this.anime_id = await response.results[0].mal_id
    console.log(this.anime_id)
  }

   getUserAnime(name: string): Observable<Anime>{
    this.setAnimeId(name)
    return this.http.get(this.url) as Observable<Anime> 
  }


  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      //Client-side or network
      console.error('An error occurred:', error.error);
    } else {
     //Back-end
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    return throwError(
      'Something bad happened; please try again later.');
  }
}
