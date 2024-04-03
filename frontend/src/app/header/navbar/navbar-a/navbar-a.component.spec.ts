import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarAComponent } from './navbar-a.component';

describe('NavbarAComponent', () => {
  let component: NavbarAComponent;
  let fixture: ComponentFixture<NavbarAComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [NavbarAComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(NavbarAComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
