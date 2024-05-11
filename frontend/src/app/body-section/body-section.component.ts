

import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-body-section',
  templateUrl: './body-section.component.html',
  styleUrl: './body-section.component.scss'
})
export class BodySectionComponent {
prevSlide() {
throw new Error('Method not implemented.');
}
nextSlide() {
throw new Error('Method not implemented.');
}
userReview(_t113: NgForm) {
throw new Error('Method not implemented.');
}
property: any;
reviews: any;
sendFormToListings(_t16: NgForm) {
throw new Error('Method not implemented.');
}
locationService: any;
categoryService: any;
locationId: any;
userService: any;
searchByName(_t42: NgForm) {
throw new Error('Method not implemented.');
}
  post:any
posts: any;
id: any;
propService: any;
stars: any;
auth: any;
  constructor(public shered:AuthService) { }
  ngOnInit():void{
    this.shered.getPost().subscribe(
      res=>{
        console.log(res)
        this.post=res
      },
      err=>{
        console.log(err)
      })
  }
}
