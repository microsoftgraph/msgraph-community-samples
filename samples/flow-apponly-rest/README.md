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

### SharePoint List

A SharePoint list with at least Title and groupId field would be needed for the Sync Flow to be properly setup - when flow is configured, the missing columns are dropped.

* Title (single line text)
* groupId (single line text)
* description (single line text)
* visibility (single line text)
* createdDateTime (datetime)
* renewedDateTime (datetime)

### Register an App-Only Permission

* Go to aad.portal.azure.com and register an app with App-Only permission for "Groups.Read.All"
* Note down the client-id (application-id) and generate a client-secret (key)
* Navigate over to Azure AD property and note down the tenant-id

### Create three Flows using the three templates in this order:

> 1. SampleSyncMSGraphGroupsToSPList.zip
> 2. SampleMSGraphGroupsListener.zip
> 3. SampleMSGraphGroupsSubscriber.zip

* In Microsoft Flow Web Site - select Import from the top-left corner.
* Pick one of the zip files and import.
* After a brief upload, we'll be asked to create a Flow as New, and also set up connection to an existing SharePoint Site (where our list is)
* Repeat for all three.
* Update Client-ID, Client-Secret and Tenant-ID in the three Flows
* Double check the Create List Item and Update List Item actions refreshed correctly.
* Because two of the workflows are HTTP Request Trigger, after saving go back into the Flow and copy the POST URL of the request - test it with Postman.

These three Flows set up a severless chain of MS Flows running forever listening to group change events in the tenant and synchronizing them to a SP List.

## References

[June 2018 Microsoft Graph Community Call](https://dev.office.com/blogs/microsoft-graph-community-call-june-5-2018)
[John Liu .NET Blog Post](http://johnliu.net/blog/2018/6/do-bulk-insertupdate-in-microsoft-flow-with-two-simple-elegant-filter-arrays)

## Contributors

|      Roles      |                        Author(s)                        |
| --------------- | ------------------------------------------------------- |
| Creator         | John Liu (Office Server Services MVP) @johnnliu         |

## Version history

| Version |     Date      |   Comments    |
| ------- | ------------- | ------------- |
| 1.0     | June 3, 2018  | Initial entry |
| 2.0     | June 14, 2018 | Updates       |

