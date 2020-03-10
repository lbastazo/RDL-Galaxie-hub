import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RdlgalaxieSharedModule } from '../shared/shared.module';

import { CONCEPT_ROUTE, ConceptComponent } from './';

@NgModule({
  imports: [RdlgalaxieSharedModule, RouterModule.forRoot([CONCEPT_ROUTE], { useHash: true })],
  declarations: [ConceptComponent],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RdlgalaxieAppConceptModule {}
