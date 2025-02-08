//
//  DetailAdapter.swift
//  iosApp
//
//  Created by Louis Legrand on 03/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import Shared

extension GenderEntity {
    
    func toDetailGenderUI() -> DetailGenderUI {
        switch self {
        case .male: return DetailGenderUI.Male
        case .female: return DetailGenderUI.Female
        }
    }
    
}

extension PersonEntity {
    
    func toDetailPersonUI() -> DetailPersonUI {
        return DetailPersonUI(gender: gender.toDetailGenderUI(), name: name, address: address, longitude: longitude, latitude: latitude, email: email, age: age, id: id, phone: phone, cell: cell, pictureUrl: pictureUrl)
    }
    
}

