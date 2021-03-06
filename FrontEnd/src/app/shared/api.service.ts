import { HttpClient, HttpHeaders, HttpBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '../core/auth/services/auth.service';
import { Observable } from 'rxjs';
import { map, mergeMap} from 'rxjs/operators';
import { Anime } from './models/anime';
import { Genre } from './models/genre';
import { Studio } from './models/studio';

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
          themes: this.checkForTheme(res),
          studios: this.checkForStudio(res)
        } 
      })
    ) 
  }

  // Checks whether the request has a theme or genre object
  checkForTheme(res: any){
    let themes = {}

    if (res.themes[0] === undefined){
      themes = {
        id: res.genres[0].mal_id,
        name: res.genres[0].name
      }
      return themes as Genre;
    } else {
      themes = {
        id: res.themes[0].mal_id,
        name: res.themes[0].name
      }
      return themes as Genre;
    }
  }

  // Checks if studio studio object is undefined
  checkForStudio(res: any){
    let studios = {}
    if (res.studios[0] === undefined){
      return null
    } else{
      studios = {
        id: res.studios[0].mal_id,
        name: res.studios[0].name
      }
      return studios as Studio; 
    }
  }
  
}
