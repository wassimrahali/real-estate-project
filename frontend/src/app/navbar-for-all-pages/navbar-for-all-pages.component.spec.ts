import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarForAllPagesComponent } from './navbar-for-all-pages.component';

describe('NavbarForAllPagesComponent', () => {
  let component: NavbarForAllPagesComponent;
  let fixture: ComponentFixture<NavbarForAllPagesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NavbarForAllPagesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NavbarForAllPagesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
