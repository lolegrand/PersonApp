//
//  MasterPersonItemView.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct MasterPersonItemView : View {
    let person: MasterPersonUI
    let onClick: () -> Void
    
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
            
            VStack(alignment: .leading) {
                Text(person.name)
                    .font(.title2)
                    .fontWeight(.bold)
                
                Text(person.email)
                    .font(.title2)
            }
            
        }.onTapGesture {
            onClick()
        }
    }
}
