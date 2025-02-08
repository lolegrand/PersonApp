//
//  GeneratorModel.swift
//  iosApp
//
//  Created by Louis Legrand on 27/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct GeneratorPersonUI {
    let id: String
    let name: String
    let gender: GeneratorGenderUI
    let ppUrl: String
}

enum GeneratorGenderUI {
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
