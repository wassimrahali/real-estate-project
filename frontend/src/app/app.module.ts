import { RealEstateMenuComponent } from './real-estate-menu/real-estate-menu.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NavbarComponent } from './header/navbar/navbar.component';
import { MdbCollapseModule } from 'mdb-angular-ui-kit/collapse';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { HeaderSectionComponent } from './header-section/header-section.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { BodySectionComponent } from './body-section/body-section.component';
import { CreatePostComponent } from './create-post/create-post.component';
import { SlickCarouselModule } from 'ngx-slick-carousel'; // Import SlickCarouselModule


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
    HeaderSectionComponent,
    FooterComponent,
    HomeComponent,
    BodySectionComponent,
    RealEstateMenuComponent,
    CreatePostComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MdbCollapseModule,
    SlickCarouselModule // Include SlickCarouselModule here


  ],
  providers: [
    provideAnimationsAsync()
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
