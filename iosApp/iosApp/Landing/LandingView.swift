import Foundation
import SwiftUI

struct LandingView: View {
    @State private var selection: String? = nil

    var body: some View {
        NavigationView {
            VStack {

                NavigationLink(destination: GeneratorScreenView(), tag: "Genetator", selection: $selection) {}
                
                NavigationLink(destination: MasterScreenView(), tag: "Master", selection: $selection) {}

                PersonAppButton(
                    text: "Generate 10 new person",
                    type: ButtonType.primary
                ) {
                    self.selection = "Genetator"
                }

                Spacer()
                    .frame(height: 16)

                PersonAppButton(
                    text: "See my person list",
                    type: ButtonType.secondary
                ) {
                    self.selection = "Master"
                }
            }
            .navigationTitle("Person App")
            .padding([.leading, .trailing], 24)
        }
    }
}

#Preview {
    LandingView()
}
