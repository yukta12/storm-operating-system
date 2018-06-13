//
//  GradientView.swift
//  StromControllerIOS
//
//  Created by Gaurav Punjabi on 6/12/18.
//  Copyright © 2018 Gaurav Punjabi. All rights reserved.
//

import Foundation
import UIKit

class GradientView : UIView {
    var colors : [UIColor] = [UIColor(red: 0, green: 4, blue: 40, alpha: 1),
                              UIColor(red: 0, green: 78, blue: 146, alpha: 1)]
    
    override func draw(_ rect: CGRect) {
        setGradient(colors)
    }
    
    func setGradient(_ colors: [UIColor]) {
        let context = UIGraphicsGetCurrentContext()
        let gradient =
    }
}
