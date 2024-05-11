import { Component, Inject, OnInit } from '@angular/core';
import { DOCUMENT } from '@angular/common';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isScrolled: boolean = false;
  navbarOpen: boolean = false;
dataSharingService: any;
locationService: any;
auth: any;

  constructor(@Inject(DOCUMENT) private document: Document) {}

  ngOnInit() {
    this.document.addEventListener('scroll', () => {
      this.isScrolled = this.document.documentElement.scrollTop > 100;
    });
  }

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }
}
