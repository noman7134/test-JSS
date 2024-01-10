## Improvements

If I had time, I would have at least done the following:

- Use AGIC (Application Gateway Ingress Controller) or nginx controller for exposing the statistics API.
- Clean up and improve the code for both applications and infrastructure.
- Use Kustomize for Kubernetes manifest files.
- Use Secret Store CSI Driver for fetching secrets from Key Vault and creating them.
- Get rid of unneccsassary files using .gitignore