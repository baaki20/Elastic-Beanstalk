# My Java App Deployment

This repository contains a simple Java application designed for deployment on AWS Elastic Beanstalk. The deployment process is automated using a GitHub Actions CI/CD pipeline, which handles building the application, packaging it, and deploying it to a specified Elastic Beanstalk environment.

## Project Objective

The objective of this lab is to demonstrate the complete deployment workflow for a Java application using AWS Elastic Beanstalk. This includes:
* Committing application code to a GitHub repository.
* Packaging the application as a source bundle.
* Uploading the source bundle to an Amazon S3 bucket.
* Deploying the application to Elastic Beanstalk by providing the S3 URL as the source.

## Lab Deliverables

The successful completion of this project will result in the following deliverables:

* **Elastic Beanstalk Application URL**: A public URL to access the deployed application.
* **GitHub Repository Link**: A link to this repository containing the application code and the GitHub Actions workflow.

## CI/CD Workflow

The `.github/workflows/ci-cd.yml` file in this repository contains the GitHub Actions workflow that automates the deployment process. The pipeline is triggered on every push to the `main` branch and performs the following steps:

1.  **Checkout Code**: The workflow checks out the latest code from the repository.
2.  **Set Up Java**: It configures the Java environment required to build the application.
3.  **Build with Maven**: The application is built using Maven, which creates a deployable `.jar` file.
4.  **Zip Package**: The `.jar` file is zipped into a source bundle (`.zip` file), which is the format required by Elastic Beanstalk.
5.  **Configure AWS Credentials**: AWS credentials from the repository's secrets are configured to allow interaction with AWS services.
6.  **Upload to S3**: The zipped application bundle is uploaded to the designated S3 bucket (`java-app-beanstalk-bucket`).
7.  **Deploy to Elastic Beanstalk**: The Elastic Beanstalk environment is updated to use the new application version, referencing the source bundle's S3 location.

This automated process ensures that the application is always up-to-date in the Elastic Beanstalk environment, which is a key part of the CI/CD pipeline.