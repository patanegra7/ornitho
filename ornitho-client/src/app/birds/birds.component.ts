import { Component, OnInit } from '@angular/core';
import { Bird } from '../bird';
import { BirdService } from '../bird.service';
import { MessageService } from '../message.service';

@Component({
  selector: 'app-birds',
  templateUrl: './birds.component.html',
  styleUrls: ['./birds.component.css']
})
export class BirdsComponent implements OnInit {

  birds: Bird[];

  selectedBird: Bird;

  constructor(private birdService: BirdService,
              private messageService: MessageService) {}

  ngOnInit() {
    this.getBirds();
  }

  getBirds(): void {
    this.birdService.getBirds()
        .subscribe(birds => this.birds = birds);
  }

  delete(bird: Bird): void {
    this.birds = this.birds.filter(h => h !== bird);
    this.birdService.deleteBird(bird).subscribe();
  }

}
