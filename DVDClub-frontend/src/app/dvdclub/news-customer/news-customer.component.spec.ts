import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewsCustomerComponent } from './news-customer.component';

describe('NewsCustomerComponent', () => {
  let component: NewsCustomerComponent;
  let fixture: ComponentFixture<NewsCustomerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewsCustomerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewsCustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
