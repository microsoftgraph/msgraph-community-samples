# Microsoft Graph Webhooks Sample for ASP.NET Core

This sample shows how to subscribe for Microsoft Graph webhooks using application (app-only) permissions and the Azure AD endpoint.

## Sample Details

|               Category               |       Description       |
| ------------------------------------ | ----------------------- |
| **Technologies Used**                | MS Flow / LogicApps     |

## Applies to

* [Microsoft Graph](https://developer.microsoft.com/en-us/graph)

## Prerequisites

> Create App-Only permission for Group.Read.All 

## Installation / Working Instructions

> Create three Flows using the three templates in this order:
> 1. SampleSyncMSGraphGroupsToSPList.zip
> 2. SampleMSGraphGroupsListener.zip
> 3. SampleMSGraphGroupsSubscriber.zip

These set up a severless chain of MS Flows running forever listening to group change events in the tenant and synchronizing 
them to a SP List.

## Contributors

|      Roles      |                        Author(s)                        |
| --------------- | ------------------------------------------------------- |
| Creator         | John Liu (Microsoft MVP) @johnnliu                      |

## Version history

| Version |     Date      |   Comments    |
| ------- | ------------- | ------------- |
| 1.0     | June 3, 2018  | Initial entry |

