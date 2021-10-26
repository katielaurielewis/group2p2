import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  public reviewForm!: FormGroup;

  constructor( private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      score: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      review: ['', Validators.required]
    })
  }

  submitReview() {
    let score = this.reviewForm.controls['genre'].value as number
    let review = this.reviewForm.controls['rating'].value

    this.addReview(score, review)
    this.reviewForm.reset()
  }

  addReview(score: number, review: string) {
    
  }
}
