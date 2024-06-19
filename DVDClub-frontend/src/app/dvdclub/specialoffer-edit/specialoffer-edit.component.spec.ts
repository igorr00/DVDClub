import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SpecialofferEditComponent } from './specialoffer-edit.component';

describe('SpecialofferEditComponent', () => {
  let component: SpecialofferEditComponent;
  let fixture: ComponentFixture<SpecialofferEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SpecialofferEditComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SpecialofferEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
