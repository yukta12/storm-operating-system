//
//  ClientSide.swift
//  StromControllerIOS
//
//  Created by Gaurav Punjabi on 6/9/18.
//  Copyright © 2018 Gaurav Punjabi. All rights reserved.
//

import Foundation
import SwiftSocket

public class ClientSide {
    
    private var port: Int32
    private var address: String
    private var socket: TCPClient
    private var isConnected: Bool
    
    init(address: String,
         port: Int32) {
        self.port = port
        self.address = address
        self.socket = TCPClient(address: address, port: port)
        
        let status = socket.connect(timeout: 10)
        
        switch status {
        case .success:
            isConnected = true
        case .failure(_):
            isConnected = false
        }
    }
    
    public func send(message: String) {
        if(isConnected) {
            socket.send(string: "command:\(message)\n")
        }
    }
}
