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
    
    init(address: String,
         port: Int32) {
        self.port = port
        self.address = address
        self.socket = TCPClient(address: address, port: port)
        
        let status = socket.connect(timeout: 10)
        
        switch status {
        case .success:
            let byteArray = (Byte)[1, 2, 3 ,4 , 5,
            var length = "\(byteArray.count)\n"
            var result = socket.send(string: length)
            switch result {
                case .success :
                    socket.send(data: byteArray)
            case .failure(_):
                    print("Did not send command")
            }
        case .failure(let error):
            print(error)
        }
    }
}
