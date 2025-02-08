import SwiftUI
import Shared

@main
struct PersonAppApplication: App {

    init() {
        let dependencyProviderHelper = DependenciesProviderHelper()
        dependencyProviderHelper.doInitKoin()
    }

    var body: some Scene {
        WindowGroup {
            LandingView()
        }
    }
}
