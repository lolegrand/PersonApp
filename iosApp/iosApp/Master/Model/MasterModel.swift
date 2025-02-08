//
//  MasterPersonUI.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct MasterPersonUI {
    let id: String
    let name: String
    let ppUrl: String
    let email: String
    let gender: MasterGenderUI
}

enum MasterGenderUI {
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
