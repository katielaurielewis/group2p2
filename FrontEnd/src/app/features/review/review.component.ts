import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/core/auth/models/user';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviewEndpoint = 'http://localhost:8090/anilib/review'
  public reviewForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient) { }

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      score: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      review: ['', Validators.required]
    })
  }
  
  submitReview() {
    this.http.post<any>(this.reviewEndpoint, this.buildReviewBody())
      .subscribe((res: any) => {
        this.reviewForm.reset()
      })
  }

  buildReviewBody() {
    let score = this.reviewForm.controls['score'].value as number
    let review = this.reviewForm.controls['review'].value
    let active = document.querySelectorAll('.carousel-item.active')[0]
    return {
      "userId": (JSON.parse(localStorage.getItem('user')!) as User).id,
      "animeId": parseInt(active.getAttribute('anime-id')!),
      "score": score,
      "review": review
    }
  }
}
