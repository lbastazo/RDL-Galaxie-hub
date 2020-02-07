import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-boutique',
  templateUrl: './boutique.component.html',
  styleUrls: ['boutique.component.scss']
})
export class BoutiqueComponent implements OnInit {
  message: string;

  constructor() {
    this.message = 'BoutiqueComponent message';
  }

  ngOnInit(): void {}
}
