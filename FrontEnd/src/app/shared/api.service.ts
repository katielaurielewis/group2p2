import { HttpClient, HttpErrorResponse, HttpHeaders, HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserAnime } from '../core/auth/models/user-anime';
import { AuthService } from '../core/auth/services/auth.service';
import { Observable, throwError, forkJoin } from 'rxjs';
import { catchError, map, mergeMap, retry, take } from 'rxjs/operators';
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


  url: string = "https://api.jikan.moe/v3/anime/"

  constructor(private http: HttpClient, private authService: AuthService, handler: HttpBackend) {
    this.http = new HttpClient(handler)
   }

  getAnimeId(name: string){
    const reqUrl = "https://api.jikan.moe/v3/search/anime?q=" + name + "&page=1&limit=1"
    return this.http.get(reqUrl)
    .pipe(mergeMap((res:any)=> // MergeMap to ensure getAnimeId returns a value before starting getAnime
      this.getAnime(res.results[0].mal_id)
    ))
  }

   getAnime(id: number): Observable<Anime>{
    return this.http.get(this.url + id).pipe(
      map((res: any) => {
        console.log(res.mal_id)
        return <Anime> {
          id: res.mal_id,
          title: res.title,
          rating: res.rating.substring(0,6),
          score: res.score,
          synopsis: res.synopsis.substring(0,200).concat("..."),
          image: res.image_url,
          themes: {
            id: res.themes[0].mal_id,
            name: res.themes[0].name
          },
          studios:{
            id: res.studios[0].mal_id,
            name: res.studios[0].name
          }
        }
      })
    ) 
  }
  
}
