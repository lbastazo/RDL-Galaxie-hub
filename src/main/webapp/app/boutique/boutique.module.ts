import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RdlgalaxieSharedModule } from '../shared/shared.module';

import { BOUTIQUE_ROUTE, BoutiqueComponent } from './';

@NgModule({
  imports: [RdlgalaxieSharedModule, RouterModule.forRoot([BOUTIQUE_ROUTE], { useHash: true })],
  declarations: [BoutiqueComponent],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RdlgalaxieAppBoutiqueModule {}
