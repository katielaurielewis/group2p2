



import { Component, OnInit } from '@angular/core';
import { Anime } from 'src/app/shared/models/anime';
import { FormGroup, FormBuilder, FormControl, Validators } from '@angular/forms';
import { AnimeService } from 'src/app/shared/anime.service';

@Component({
  selector: 'app-adder',
  templateUrl: './adder.component.html',
  styleUrls: ['./adder.component.css']
})
export class AdderComponent implements OnInit {
  public addForm!: FormGroup;
  anime!: Anime;
  addEndpoint = "http://localhost:8090/anilib/anilib/addAnime"
  constructor(private formBuilder: FormBuilder, private animeService: AnimeService) { 
  }

  ngOnInit(): void {
    this.addForm = this.formBuilder.group({
      title: ''
    })
  }

  addAnime(){



    console.log(this.addForm.get("title")?.value)
    this.animeService.addUserAnime(this.addForm.get("title")?.value)



    this.addForm.reset()
    

  }

}
