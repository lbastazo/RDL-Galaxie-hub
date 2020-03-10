import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RdlgalaxieSharedModule } from '../shared/shared.module';

import { EQUIPE_ROUTE, EquipeComponent } from './';

@NgModule({
  imports: [RdlgalaxieSharedModule, RouterModule.forRoot([EQUIPE_ROUTE], { useHash: true })],
  declarations: [EquipeComponent],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RdlgalaxieAppEquipeModule {}
