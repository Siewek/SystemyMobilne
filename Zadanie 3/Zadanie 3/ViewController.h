//
//  ViewController.h
//  Zadanie 3
//
//  Created by Michał on 06/11/2021.
//  Copyright © 2021 Michał. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface ViewController : UIViewController
@property (weak, nonatomic) IBOutlet UIButton *informationButton;
@property (weak, nonatomic) IBOutlet UIImageView *image;

- (IBAction)InformationClicked;

@end

