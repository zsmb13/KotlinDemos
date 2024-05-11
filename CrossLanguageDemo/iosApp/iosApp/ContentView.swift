import SwiftUI
import Shared

struct ContentView: View {
    @State private var input: String = ""
    @State private var result: String? = nil

    var body: some View {
        VStack {
            Spacer(minLength: 1)

            CircleLogoView()

            TextField("Enter circle radius", text: $input)
                .padding([.leading, .trailing], 20)

            Button("Calculate!") {
                let calculator = Calculator()
                let radius = Double(input) ?? 0.0
                let area = calculator.circleArea(radius: radius)
                result = String(area)
            }

            if let res = result {
                Text("Area: \(res)")
            }

            Spacer(minLength: 1)
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .center)
        .padding()
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

struct CircleLogoView: View {
    let colors: [Color] = [
        Color(red: 0xBE / 255, green: 0x18 / 255, blue: 0xE6 / 255),
        Color(red: 0x5C / 255, green: 0x9E / 255, blue: 0xE8 / 255),
        Color(red: 0x7A / 255, green: 0xC3 / 255, blue: 0x00 / 255),
        Color(red: 0xEF / 255, green: 0x85 / 255, blue: 0x39 / 255),
        Color(red: 0xBE / 255, green: 0x18 / 255, blue: 0xE6 / 255),
    ]

    var body: some View {
        Circle()
            .strokeBorder(
                AngularGradient(
                    gradient: Gradient(colors: colors),
                    center: .center,
                    startAngle: .zero,
                    endAngle: .degrees(360)
                ),
                lineWidth: 32
            )
            .frame(width: 200, height: 200)
    }
}
