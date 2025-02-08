import Foundation
import SwiftUI

struct PersonAppButton: View {
    let text: String
    let type: ButtonType
    let action: () -> Void

    var body: some View {
        Button {
            action()
        } label: {
            ZStack {
                Rectangle()
                    .cornerRadius(25)
                    .foregroundColor(type.backgroundColor())
                    .frame(maxWidth: .infinity)
                    .frame(height: 48)

                Text("\(text)")
                    .foregroundColor(type.textColor())
            }

        }
    }

}

enum ButtonType: String {
    case primary, secondary, error

    func backgroundColor() -> Color {
        var color: Color!
        switch self {
        case .primary: color = SwiftUI.Color.myPrimary
        case .secondary: color = SwiftUI.Color.mySecondary
        case .error: color = SwiftUI.Color.error
        }
        return color
    }

    func textColor() -> Color {
        var color: Color!
        switch self {
        case .primary: color = SwiftUI.Color.onPrimary
        case .secondary: color = SwiftUI.Color.onSecondary
        case .error: color = SwiftUI.Color.onSecondary
        }
        return color
    }
}

#Preview {
    VStack {
        PersonAppButton(
            text: "Button",
            type: ButtonType.primary,
            action: {}
        )

        PersonAppButton(
            text: "Button",
            type: ButtonType.secondary,
            action: {}
        )

    }
}
