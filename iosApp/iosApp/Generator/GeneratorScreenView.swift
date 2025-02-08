//
//  GeneratorView.swift
//  iosApp
//
//  Created by Louis Legrand on 27/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI

struct GeneratorScreenView: View {

    @StateObject private var viewModel = ViewModel()
    
    var body: some View {
        HStack {
            switch viewModel.state {

            case .Idle:
                PersonAppButton(
                    text: "Generate 10 new persons",
                    type: ButtonType.secondary) {
                        Task {
                            await viewModel.generate10Person()
                        }
                    }
                    .padding([.leading, .trailing], 16)

            case .Error:
                Text("An error occured")

            case .Loading:
                ProgressView()

            case .Success(let data):
                GeneratorPersonListView(persons: data)
                    

            }
        }.navigationTitle("Person Generator")
    }
}
