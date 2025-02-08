//
//  GeneratorModelAdapter.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

extension PersonEntity {
    
    func toGeneratorPersonUI() -> GeneratorPersonUI {
        return GeneratorPersonUI(
            id: self.id,
            name: self.name,
            gender: self.gender.toGeneratorGenderUI(),
            ppUrl: self.pictureUrl
        )
    }
    
}

extension [PersonEntity] {
    
    func toGeneratorPersonUIList() -> [GeneratorPersonUI] {
        self.map { personEntity in
            personEntity.toGeneratorPersonUI()
        }
    }
    
}


extension GenderEntity {
    
    func toGeneratorGenderUI() -> GeneratorGenderUI {
        switch self {
        case .male: return GeneratorGenderUI.Male
        case .female: return GeneratorGenderUI.Female
        default : return GeneratorGenderUI.Male
        }
    }
    
}
