import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BodySectionComponent } from './body-section.component';

describe('BodySectionComponent', () => {
  let component: BodySectionComponent;
  let fixture: ComponentFixture<BodySectionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BodySectionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BodySectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
