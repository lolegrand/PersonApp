//
//  GeneratorViewModel.swift
//  iosApp
//
//  Created by Louis Legrand on 27/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import Shared

extension GeneratorScreenView {
    
    class ViewModel: ObservableObject {
        
        init() { }
        
        private let personRepository: PersonRepository = get()
        
        @Published var state: State = State.Idle
        
        @MainActor
        func generate10Person() async {
            state = State.Loading
            
            do {
                let persons = try await personRepository.generate10Person()
                state = State.Success(data: persons.toGeneratorPersonUIList())
            } catch {
                state = State.Error
            }
            
        }
    }
    
    enum State {
        case Idle
        
        case Loading
        
        case Error
        
        case Success(data: [GeneratorPersonUI])
    }
}
