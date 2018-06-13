//
//  ViewController.swift
//  StromControllerIOS
//
//  Created by Gaurav Punjabi on 6/9/18.
//  Copyright © 2018 Gaurav Punjabi. All rights reserved.
//

import UIKit
import FontAwesome_swift

class ViewController: UIViewController {

    private var clientSide : ClientSide?
    
    @IBOutlet weak var backgroundView: UIView!
    @IBOutlet weak var upButton: UIButton!
    @IBOutlet weak var downButton: UIButton!
    @IBOutlet weak var leftButton: UIButton!
    @IBOutlet weak var rightButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        UINavigationBar.appearance().backgroundColor = UIColor.black;
        upButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 50)
        upButton.setTitle(String.fontAwesomeIcon(code: "fa-angle-up"), for: .normal)
        downButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 50)
        downButton.setTitle(String.fontAwesomeIcon(name: .angleDown), for: .normal)
        rightButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 50)
        rightButton.setTitle(String.fontAwesomeIcon(name: .angleRight), for: .normal)
        leftButton.titleLabel?.font = UIFont.fontAwesome(ofSize: 50)
        leftButton.setTitle(String.fontAwesomeIcon(name: .angleLeft), for: .normal)
        
        clientSide = ClientSide(address: "192.168.0.51", port: 8080)
    }
    @IBAction func okActionPerformed(_ sender: Any) {
        clientSide?.send(message: Constants.OK_COMMAND)
    }
    @IBAction func upActionPerformed(_ sender: Any) {
        clientSide?.send(message: Constants.UP_COMMAND)
    }
    @IBAction func leftActionPerformed(_ sender: Any) {
        clientSide?.send(message: Constants.LEFT_COMMAND)
    }
    @IBAction func rightActionPerformed(_ sender: Any) {
        clientSide?.send(message: Constants.RIGHT_COMMAND)
    }
    @IBAction func downActionPerformed(_ sender: Any) {
        clientSide?.send(message: Constants.DOWN_COMMAND)
    }
}

