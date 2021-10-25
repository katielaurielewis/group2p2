import { Component, OnInit } from '@angular/core';
import { Anime } from 'src/app/shared/models/anime';
import { FormGroup, FormBuilder, FormControl } from '@angular/forms';
import { AnimeService } from 'src/app/shared/anime.service';

@Component({
  selector: 'app-adder',
  templateUrl: './adder.component.html',
  styleUrls: ['./adder.component.css']
})
export class AdderComponent implements OnInit {

  addForm = new FormControl;
  anime!: Anime;
  addEndpoint = "http://localhost:8090/anilib/anilib/addAnime"
  constructor(private formBuilder: FormBuilder, private animeService: AnimeService) { }

  ngOnInit(): void {
  }

  addAnime(){
    let animeName = this.addForm.value
    this.animeService.addUserAnime(animeName)
  }

}
