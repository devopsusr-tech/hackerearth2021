import {Component, Input} from '@angular/core';
import {Location} from '@angular/common';


@Component({
  selector: 'app-top-navigation',
  templateUrl: './top-navigation.component.html',
  styleUrls: ['./top-navigation.component.scss']
})
export class TopNavigationComponent {
  @Input()
  showForward = false;
  @Input()
  backText = '';
  @Input()
  forwardText = '';
  @Input()
  forwardClicked = () => {
  }

  constructor(private location: Location) {
  }

  backClicked(): void {
    this.location.back();
  }
}



