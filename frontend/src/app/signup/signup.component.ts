import { Component } from '@angular/core';
import { AuthService } from '../auth.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'c',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
signUpSubmit(_t20: NgForm) {
throw new Error('Method not implemented.');
}
  form: any = {
    username: null,
    email: null,
    password: null
  };
  isSignUpFailed = false;
  errorMessage = '';
errorFlag: any;
user: any;

  constructor(private authService: AuthService) { }

  onSubmit(): void {
    const { username, email, password } = this.form;

    this.authService.signup({ username, email, password }).subscribe(
      data => {
        console.log(data);
        // Optionally, you can redirect the user to login page after successful registration
      },
      err => {
        this.errorMessage = err.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
}
