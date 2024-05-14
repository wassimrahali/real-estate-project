import { ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
import { Post } from '../post.model'; // Import the Post model
import { HttpClient } from '@angular/common/http'; // Import HttpClient module
import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.scss']
})
export class PostDetailComponent implements OnInit {
  post!: Post; // Assuming you have a Post object to represent the post details
  images: string[] = [];
  imgId: number = 1;

  @ViewChild('imgShowcase') imgShowcase!: ElementRef;

  constructor(
    private route: ActivatedRoute,
    private authService: AuthService,
    private http: HttpClient // Inject HttpClient module
  ) { }

  ngOnInit(): void {
    this.getPostDetails();
    window.addEventListener('resize', () => this.slideImage());
  }

  getPostDetails(): void {
    const postId = this.route.snapshot.paramMap.get('id'); // Assuming you're using ActivatedRoute to get post id
    // Assuming your backend API endpoint returns the post details including image URLs
    this.http.get<Post>('http://localhost:8090/post/' + postId)
      .subscribe((post: Post) => {
        this.post = post;
        this.images = post.images; // Assuming images is an array of image URLs in your Post model
      });
  }
  selectImage(id: number): void {
    this.imgId = id;
    this.slideImage();
  }

  slideImage(): void {
    const displayWidth = this.imgShowcase.nativeElement.querySelector('img').clientWidth;
    this.imgShowcase.nativeElement.style.transform = `translateX(${- (this.imgId - 1) * displayWidth}px)`;
  }
}
