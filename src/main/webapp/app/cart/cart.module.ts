import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { RdlgalaxieSharedModule } from '../shared/shared.module';

import { CART_ROUTE, CartComponent } from './';

@NgModule({
  imports: [RdlgalaxieSharedModule, RouterModule.forRoot([CART_ROUTE], { useHash: true })],
  declarations: [CartComponent],
  entryComponents: [],
  providers: [],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class RdlgalaxieAppCartModule {}
