//
//  DetailScreenView.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import SwiftUI

struct DetailScreenView : View {
    let id: String
    let onPersonDeleted: (String) -> Void
    
    @StateObject private var viewModel = ViewModel()
    @Environment(\.presentationMode) var presentationMode
    
    var body: some View {
        
        HStack {
            switch viewModel.state {
                
            case .Error :
                Text("An error occured")
                
            case .Loading :
                ProgressView()
                
            case .Success(let data):
                DetailPersonView(person: data) {
                    onPersonDeleted(data.id)
                    presentationMode.wrappedValue.dismiss()
                }
            }
        }.onAppear {
            Task {
                await viewModel.fetchPersonById(id: id)
            }
        }
        
    }
    
}
