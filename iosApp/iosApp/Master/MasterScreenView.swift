//
//  MasterView.swift
//  iosApp
//
//  Created by Louis Legrand on 27/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct MasterScreenView: View {
    
    @StateObject private var viewModel = ViewModel()

    var body: some View {
        
        HStack {
            switch viewModel.state {

            case .Error:
                Text("An error occured")

            case .Loading:
                ProgressView()

            case .Success(let data):
                MasterPersonListView(
                    persons: data
                ) { id in
                        Task {
                            await viewModel.deletePerson(id: id)
                        }
                }

            }
        }.navigationTitle("Person List")
        
    }

}
