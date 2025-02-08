//
//  GeneratePersonListView.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct GeneratorPersonListView: View {

    let persons: [GeneratorPersonUI]

    var body: some View {

        List(persons, id: \.id) { person in

            GeneratorPersonItemView(person: person)

        }

    }

}
