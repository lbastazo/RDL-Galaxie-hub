import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'jhi-concept',
  templateUrl: './concept.component.html',
  styleUrls: ['concept.component.scss']
})
export class ConceptComponent implements OnInit {
  message: string;

  constructor() {
    this.message = 'ConceptComponent message';
  }

  ngOnInit(): void {}
}
