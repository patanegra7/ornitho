
import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { SightingsComponent }   from './sightings/sightings.component';
import { BirdsComponent }       from './birds/birds.component';
import { BirdDetailComponent }  from './bird-detail/bird-detail.component';

const routes: Routes = [
  { path: '', redirectTo: '/sightings', pathMatch: 'full' },
  { path: 'sightings', component: SightingsComponent },
  { path: 'birds', component: BirdsComponent },
  { path: 'bird/:id', component: BirdDetailComponent },
  { path: 'bird', component: BirdDetailComponent }
];


@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
