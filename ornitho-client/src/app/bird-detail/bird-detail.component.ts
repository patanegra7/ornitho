import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
// Ornitho App
import { Bird } from '../bird';
import { BirdService }  from '../bird.service';

@Component({
  selector: 'app-bird-detail',
  templateUrl: './bird-detail.component.html',
  styleUrls: ['./bird-detail.component.css']
})
export class BirdDetailComponent implements OnInit {

  @Input() bird: Bird;

  constructor(
    private route: ActivatedRoute,
    private birdService: BirdService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getBird();
  }

  getBird(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if(id!=null) {
      this.birdService.getBird(id).subscribe(bird => this.bird = bird);
    } else {
      this.bird = new Bird;
    }
  }

  save(): void {

    console.log(this.bird);

    if(this.bird.id!=null) {
      // Update
      this.birdService.updateBird(this.bird).subscribe(() => this.goBack());
    } else {
      // New
      this.birdService.addBird(this.bird).subscribe(() => this.goBack());
    }
  }

  goBack(): void {
    this.location.back();
  }
}
