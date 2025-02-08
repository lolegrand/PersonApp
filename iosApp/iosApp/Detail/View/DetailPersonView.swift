//
//  DetailPersonView.swift
//  iosApp
//
//  Created by Louis Legrand on 03/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct DetailPersonView: View {
    
    let person: DetailPersonUI
    let onDelete: () -> Void
    
    var body: some View {
        VStack {
            
            AsyncImage(
                url: URL(string: person.pictureUrl)
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
            .frame(width: 128, height: 128)
            PersonInfoItem(key: "Name : ", value: person.name)
            Divider()
            PersonInfoItem(key: "Address : ", value: person.address)
            Divider()
            PersonInfoItem(key: "Email : ", value: person.email)
            Divider()
            PersonInfoItem(key: "Age : ", value: String(person.age))
            Divider()
            PersonInfoItem(key: "Phone : ", value: person.phone)
            Divider()
            PersonInfoItem(key: "Cell : ", value: person.cell)
            
            
        }
        .padding([.leading, .trailing], 24)
        .toolbar(content: {
            Button("Delete") {
                onDelete()
            }
        })
        .navigationTitle(person.name)
    }
    
}

private struct PersonInfoItem: View {
    let key : String
    let value : String
    
    var body: some View {
        
        HStack {
            
            Text(key).bold()
            
            Spacer().frame(minWidth: 0, maxWidth: .infinity)
            
            Text(value)
            
        }
        
    }
    
}
