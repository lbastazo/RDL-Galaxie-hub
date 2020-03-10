import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['equipe.component.scss']
})
export class EquipeComponent implements OnInit {
  message: string;

  constructor() {
    this.message = 'EquipeComponent message';
  }

  ngOnInit(): void {}
}
