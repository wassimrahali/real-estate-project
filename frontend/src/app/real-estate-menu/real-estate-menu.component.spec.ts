import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealEstateMenuComponent } from './real-estate-menu.component';

describe('RealEstateMenuComponent', () => {
  let component: RealEstateMenuComponent;
  let fixture: ComponentFixture<RealEstateMenuComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RealEstateMenuComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RealEstateMenuComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
