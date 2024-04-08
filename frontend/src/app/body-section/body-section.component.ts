import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-body-section',
  templateUrl: './body-section.component.html',
  styleUrl: './body-section.component.scss'
})
export class BodySectionComponent {
  post:any
posts: any;
id: any;
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
