//
//  MasterAdapter.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

extension GenderEntity {
    
    func toMasterGenderUI() -> MasterGenderUI {
        switch self {
        case .male: return MasterGenderUI.Male
        case .female: return MasterGenderUI.Female
        }
    }
    
}

extension [PersonEntity] {
    
    func toMasterPersonUIList() -> [MasterPersonUI] {
        return self.map { personEntity in
            personEntity.toMasterPersonUI()
        }
    }
    
}

extension PersonEntity {
    
    func toMasterPersonUI() -> MasterPersonUI {
        return MasterPersonUI(id: id, name: name, ppUrl: pictureUrl, email: email, gender: gender.toMasterGenderUI())
    }
    
}
