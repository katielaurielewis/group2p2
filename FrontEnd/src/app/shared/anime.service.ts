import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

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

  endpoint = "http://localhost:8090/anilib/library"

  constructor(private http : HttpClient) { }

  // searchAnime(name: String){
  //   JikanTS.Search.search("{name}", "anime", 1, {limit: 1}).then((b: any) => console.log(b))
  // }

}
