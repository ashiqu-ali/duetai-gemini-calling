<img src="https://avatars2.githubusercontent.com/u/2810941?v=3&s=96" alt="Google Cloud Platform logo" title="Google Cloud Platform" align="right" height="96" width="96"/>

# DuetAI Gemini Cloud Function

This project contains a simple HTTP-triggered Cloud Function named `GeminiService` for interacting with the DuetAI Gemini model. The function takes a JSON payload as input, invokes the Gemini model, and returns the generated responses.



## Getting Started

### Prerequisites
1. Ensure you have a Google Cloud account. [Create an account](https://console.cloud.google.com/freetrial/signup/tos) if you don't have one.
2. Install [Git](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git) for copying samples to your machine.
3. Install the [Cloud Code plugin](https://cloud.google.com/code/docs/vscode/install#installing).
4. Install the [pre-release build](https://cloud.google.com/code/docs/vscode/insiders#get) for Cloud Functions integration.

### Setting Up
1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/duetai-gemini.git
3. Open the project in your preferred IDE.

### Deploying the Function
1. Right-click the `GeminiService` class and select **Deploy function**.
2. In the Quickpick menu, choose a Google Cloud project to deploy the function to.
3. Select a region for deployment.
4. Choose a runtime for the function.

The deployment process may take a few minutes. Check the **Output** tab for any error messages if the deployment fails.

## Learn More
For additional learning resources and inspiration, credit goes to the [Bookshelf builder: Use Duet AI to build a Java Cloud Function for a Gemini application](https://codelabs.developers.google.com/bookshelf-duetai-bigquery#11).
