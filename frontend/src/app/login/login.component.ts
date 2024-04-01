import { Component } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
toggleNavbar() {
throw new Error('Method not implemented.');
}
  form: any = {
    username: null,
    password: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
navbarOpen: any;

  constructor(private authService: AuthService) { }

  onSubmit(): void {
    const { username, password } = this.form;

    this.authService.login({ username, password }).subscribe(
      data => {
        console.log(data);
        this.isLoggedIn = true;
        this.isLoginFailed = false;
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
}
