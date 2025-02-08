//
//  DetailModel.swift
//  iosApp
//
//  Created by Louis Legrand on 03/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct DetailPersonUI {
    let gender : DetailGenderUI
    let name : String
    let address : String
    let longitude : Float
    let latitude : Float
    let email : String
    let age : Int32
    let id : String
    let phone : String
    let cell : String
    let pictureUrl : String
}


enum DetailGenderUI {
    case Male, Female
    
    func color() -> Color {
        let color: Color!
        switch self {
        case .Male: color = SwiftUI.Color.colorMale
        case .Female: color = SwiftUI.Color.colorFemale
        }
        return color
    }
}


