//
//  DependenciesProviderHelper.swift
//  iosApp
//
//  Created by Louis Legrand on 28/01/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import Foundation
import Shared

func get<A: AnyObject>() -> A {
    return DependenciesProviderHelper.companion.koin.get(objCClass: A.self) as! A
}

func get<A: AnyObject>(_ type: A.Type) -> A {
    return DependenciesProviderHelper.companion.koin.get(objCClass: A.self) as! A
}

func get<A: AnyObject>(_ type: A.Type, qualifier: (any Koin_coreQualifier)? = nil, parameter: Any) -> A {
    return DependenciesProviderHelper.companion.koin.get(objCClass: A.self, qualifier: qualifier, parameter: parameter) as! A
}
