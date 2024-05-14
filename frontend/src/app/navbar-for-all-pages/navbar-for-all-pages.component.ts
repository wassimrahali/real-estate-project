import { DOCUMENT } from '@angular/common';
import { Component, Inject } from '@angular/core';

@Component({
  selector: 'app-navbar-for-all-pages',
  templateUrl: './navbar-for-all-pages.component.html',
  styleUrl: './navbar-for-all-pages.component.scss'
})
export class NavbarForAllPagesComponent {
  isScrolled: boolean = false;
  navbarOpen: boolean = false;
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
