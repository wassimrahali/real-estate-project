import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrl: './user-profile.component.scss'
})
export class UserProfileComponent {
  constructor(public shared: AuthService,private router:Router) { }
  user:any;

    ngOnInit(){

      this.shared.getUserById(1).subscribe(
        res=>{
          console.log(res)
          this.user=res
        },
        err=>{
          console.log(err)
        }
      )
    }
    Update(){
      this.shared.updateUserById(this.user).subscribe(
        res=>{
          console.log('updated '+res)

        },
        err=>{
          console.log(err)
        }
      )
    }
    Delete(){
      this.shared.DeleteUser(1).subscribe(
        res=>{
          console.log(res)
          this.user=res
          this.router.navigate(["/list"]);
        },
        err=>{
          console.log(err)
        }
      )
    }
    }


