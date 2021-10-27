import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnInit } from '@angular/core';
import { User } from 'src/app/core/auth/models/user';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  @Input()
  submitReview!: Function;


  public reviewForm!: FormGroup;

  constructor( private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      score: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      review: ['', Validators.required]
    })
  }

  addReview() {
    let score = this.reviewForm.controls['score'].value
    let review = this.reviewForm.controls['review'].value
    this.submitReview(score, review)
    this.reviewForm.reset()
  }

  /*submitReview() {
    let score = this.reviewForm.controls['genre'].value as number
    let review = this.reviewForm.controls['rating'].value

    this.addReview(score, review)
    this.reviewForm.reset()
  }

  addReview(score: number, review: string) {
    
  }*/

  user = JSON.parse(localStorage.getItem('user')!) as User

  @Input()
  anime: any

  url = "http://localhost:8090/anilib/user/"










}
