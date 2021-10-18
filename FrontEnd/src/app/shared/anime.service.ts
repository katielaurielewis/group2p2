import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import JikanTS from "jikants";




@Injectable({
  providedIn: 'root'
})
export class AnimeService {

  constructor(private http : HttpClient, ) { }

  getIdFromAPI(){
    JikanTS.Search.search("Samurai Champloo", "anime", 1, {limit: 1}).then(b=> console.log(b));
  }



}
