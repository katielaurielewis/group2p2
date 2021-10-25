import { Component, OnInit } from '@angular/core';
import { Anime } from 'src/app/shared/models/anime';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-adder',
  templateUrl: './adder.component.html',
  styleUrls: ['./adder.component.css']
})
export class AdderComponent implements OnInit {

  public addForm!: FormGroup;
  anime!: Anime;
  addEndpoint = "http://localhost:8090/anilib/anilib/addAnime"
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
  }

  addAnime(){
    //whoops
  }

}
