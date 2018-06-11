//
//  ViewController.swift
//  StromControllerIOS
//
//  Created by Gaurav Punjabi on 6/9/18.
//  Copyright © 2018 Gaurav Punjabi. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        var client = ClientSide(address: "192.168.0.158", port: 9090)
        print("Congrats")
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    
}

