import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { AnimeService } from 'src/app/shared/anime.service';

@Component({
  selector: 'app-recommender',
  templateUrl: './recommender.component.html',
  styleUrls: ['./recommender.component.css']
})
export class RecommenderComponent implements OnInit {

  name = new FormControl('');
  constructor(private animeService: AnimeService) { }

  ngOnInit(): void {
  }

  // displayAnime(){
  //   this.animeService.searchAnime(this.name.value)
  // }
}
