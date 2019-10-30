import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';

import { BirdsComponent } from './birds/birds.component';
import { BirdDetailComponent } from './bird-detail/bird-detail.component';
import { BirdService} from './bird.service';
import { MessagesComponent } from './messages/messages.component';
import { MessageService } from './message.service';
import { AppRoutingModule } from './/app-routing.module';
import { SightingsComponent } from './sightings/sightings.component';

@NgModule({
  declarations: [
    AppComponent,
    BirdsComponent,
    BirdDetailComponent,
    MessagesComponent,
    SightingsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [BirdService, MessageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
