# Microsoft Graph Webhooks Sample for Microsoft Flow

This sample shows how to subscribe to Microsoft Graph webhooks using application (app-only) permissions and Microsoft Flow.

## Sample Details

|               Category               |       Description       |
| ------------------------------------ | ----------------------- |
| **Technologies Used**                | MS Flow / LogicApps     |

## Applies to

* [Microsoft Graph](https://developer.microsoft.com/en-us/graph)
* [Microsoft Flow](https://flow.microsoft.com/)

## Prerequisites

> Create App-Only permission for Group.Read.All 

## Installation / Working Instructions

> Create three Flows using the three templates in this order:
> 1. SampleSyncMSGraphGroupsToSPList.zip
> 2. SampleMSGraphGroupsListener.zip
> 3. SampleMSGraphGroupsSubscriber.zip

These set up a severless chain of MS Flows running forever listening to group change events in the tenant and synchronizing them to a SP List.

A SharePoint list with at least Title and groupId field would be needed for the Sync Flow to be properly setup - when flow is configured, the missing columns are dropped.

* Title (single line text)
* groupId (single line text)
* description (single line text)
* visibility (single line text)
* createdDateTime (datetime)
* renewedDateTime (datetime)

## Contributors

|      Roles      |                        Author(s)                        |
| --------------- | ------------------------------------------------------- |
| Creator         | John Liu (Office Server Services MVP) @johnnliu         |

## Version history

| Version |     Date      |   Comments    |
| ------- | ------------- | ------------- |
| 1.0     | June 3, 2018  | Initial entry |

