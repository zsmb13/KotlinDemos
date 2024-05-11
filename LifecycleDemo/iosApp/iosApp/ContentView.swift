import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        if #available(iOS 16.0, *) {
            NavigationStack {
                ComposeView()
                    .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
                NavigationLink(value: "SecondView") {
                    Text("Navigate away")
                }
                .navigationDestination(for: String.self) { view in
                    if view == "SecondView" {
                        Text("This is a second View")
                    }
                }
            }
        } else {
            // Fallback on earlier versions
        }
    }
}



