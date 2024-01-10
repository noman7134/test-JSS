terraform {
  backend "azurerm" {
    resource_group_name  = "myrg"
    storage_account_name = "terraformstate"
    container_name       = "tfstate"
    key                  = "terraform.tfstate"
  }
}