import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/core/auth/models/user';


@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent implements OnInit {

  reviewEndpoint = 'http://localhost:8090/anilib/review'
  public reviewForm!: FormGroup;

  constructor(private formBuilder: FormBuilder, private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.reviewForm = this.formBuilder.group({
      score: ['', [Validators.required, Validators.min(0), Validators.max(10)]],
      review: ['', Validators.required]
    })
  }

  submitReview() {
    let active = document.querySelectorAll('.carousel-item.active')[0]
    this.http.post<any>(this.reviewEndpoint, this.buildReviewBody(active))
      .subscribe((res: any) => {
        this.reviewForm.reset()
      })
    this.http.post<any>(this.buildSetWatchedURI(active), {})
      .subscribe((res: any) => {
        console.log("set to watched after submitting review")
        location.reload();
      })
  }

  buildReviewBody(active: Element) {
    let score = this.reviewForm.controls['score'].value as number
    let review = this.reviewForm.controls['review'].value
    return {
      "userId": (JSON.parse(localStorage.getItem('user')!) as User).id,
      "animeId": parseInt(active.getAttribute('anime-id')!),
      "score": score,
      "review": review
    }
  }

  buildSetWatchedURI(active: Element) {
    let userId = (JSON.parse(localStorage.getItem('user')!) as User).id
    let animeId = parseInt(active.getAttribute('anime-id')!)
    return "http://localhost:8090/anilib/library/" + userId + "/" + animeId + "/setWatched"
  }
}
