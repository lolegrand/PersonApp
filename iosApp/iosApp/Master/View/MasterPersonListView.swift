//
//  MasterPersonListView.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct MasterPersonListView : View {
    let persons: [MasterPersonUI]
    let onPersonDeleted: (String) -> Void
    
    @State private var selection: String? = nil
    
    var body: some View {

        List(persons, id: \.id) { person in
            NavigationLink(
                destination: DetailScreenView(
                    id: person.id,
                    onPersonDeleted: { id in
                        onPersonDeleted(id)
                    }
                ),
                tag: person.id,
                selection: $selection
            ) {
                MasterPersonItemView(person: person) {
                    self.selection = person.id
                }
            }
        }
    }
    
}
