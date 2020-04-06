import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['cart.component.scss']
})
export class CartComponent implements OnInit {
  message: string;

  constructor() {
    this.message = 'CartComponent message';
  }

  ngOnInit(): void {}
}
