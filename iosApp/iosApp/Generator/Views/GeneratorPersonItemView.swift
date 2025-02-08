//
//  GeneratorPersonItemView.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct GeneratorPersonItemView : View {
    let person: GeneratorPersonUI
    
    var body: some View {
        HStack {
            
            AsyncImage(
                url: URL(string: person.ppUrl)
            ) { result in
                result.image?
                    .resizable()
                    .scaledToFill()
            }
            .clipShape(Circle())
            .overlay(
                Circle()
                    .stroke(person.gender.color(), lineWidth: 4)
            )
            .frame(width: 64, height: 64)
            
            Text(person.name)
                .font(.title2)
                .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
            
        }
    }
}

#Preview {
    GeneratorPersonItemView(
        person: GeneratorPersonUI(
            id: "1",
            name: "Mr Alerendro Marshall",
            gender: GeneratorGenderUI.Female,
            ppUrl: "https://randomuser.me/api/portraits/men/29.jpg"
        )
    )
}
