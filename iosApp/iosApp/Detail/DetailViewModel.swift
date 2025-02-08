//
//  DetailViewModel.swift
//  iosApp
//
//  Created by Louis Legrand on 03/02/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

extension DetailScreenView {
    
    class ViewModel: ObservableObject {
        
        private let personRepository: PersonRepository = get()
        
        @Published var state: State = State.Loading
        
        @MainActor
        func fetchPersonById(id: String) async {
            state = State.Loading
            
            do {
                let person = try await personRepository.getPersonById(personId: id)
                state = .Success(data: person.toDetailPersonUI())
            } catch {
                state = .Error
            }
        }

        enum State {
            case Error
            
            case Loading
            
            case Success(data: DetailPersonUI)
        }
        
    }
    
}
