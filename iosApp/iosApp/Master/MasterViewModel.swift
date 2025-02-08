//
//  MasterViewModel.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

extension MasterScreenView {
    
    class ViewModel: ObservableObject {
        
        init() { 
            Task {
                await fetchAllPerson()
            }
        }
        
        private let personRepository: PersonRepository = get()
        
        @Published var state: State = State.Loading
        
        @MainActor
        func fetchAllPerson() async {
            state = State.Loading
            
            for await persons in personRepository.watchAllPersons() {
                state = State.Success(data: persons.toMasterPersonUIList())
            }
        }
        
        @MainActor
        func deletePerson(id: String) async {
            do {
                try await personRepository.removePerson(personId: id)
            } catch {
                state = State.Error
            }
        }
        
        enum State {
            case Error
            
            case Loading
            
            case Success(data: [MasterPersonUI])
        }
        
    }
    
    
}
