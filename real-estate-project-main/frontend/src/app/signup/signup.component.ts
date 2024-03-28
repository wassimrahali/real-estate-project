import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'c',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent {
  form: any = {
    username: null,
    email: null,
    password: null
  };
  isSignUpFailed = false;
  errorMessage = '';

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
