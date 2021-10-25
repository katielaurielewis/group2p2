import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AnimeService } from 'src/app/shared/anime.service';
import { Anime } from 'src/app/shared/models/anime';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Genre } from 'src/app/shared/models/genre';
import { ApiService } from 'src/app/shared/api.service';

@Component({
  selector: 'app-recommender',
  templateUrl: './recommender.component.html',
  styleUrls: ['./recommender.component.css']
})
export class RecommenderComponent implements OnInit {

  public recommendationForm!: FormGroup;
  recommendedAnime: Anime | undefined;
  buttonDisabled = false;
  constructor(private animeService: AnimeService, private formBuilder: FormBuilder, private apiService:ApiService) { }

  ngOnInit(): void {
    this.recommendationForm = this.formBuilder.group({
      genre: ['', Validators.required],
      rating: ['', Validators.required]
    })
  }

  recommendAnime() {
    var genre = this.recommendationForm.controls['genre'].value
    var rating = this.recommendationForm.controls['rating'].value

    // mocking out anime object until endpoint is fixed
    var anime = new Anime()
    var genreObj = new Genre()
    // genreObj.name = "Action"
    // anime.title = "Title!"
    // anime.rating = "PG-13"
    // anime.synopsis = "This the synopsis for the anime!"
    // anime.themes = genreObj
    // this.recommendedAnime = anime
    
    // doesn't work until recommend endpoint is fixed in back end
    this.animeService.recommendAnime(genre, rating).then((res: Anime) => {
      this.recommendedAnime = res;
      this.buttonDisabled = false;
    })
  }
}
