# Contribution Guidance

If you'd like to contribute to this repository, please read the following guidelines. Contributors are more than welcome to share your learnings with others from centralized location.

## Code of Conduct

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information, see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Question or Problem?

Please do not open GitHub issues for general support questions as the GitHub list should be used for feature requests and bug reports. This way we can more easily track actual issues or bugs from the code and keep the general discussion separate from the actual code.

If you have questions about how to use the Microsoft Graph or any of the provided samples, please use the following locations.

* [Microsoft Graph](https://developer.microsoft.com/en-us/graph)
* [Microsoft Graph Documentation](https://developer.microsoft.com/en-us/graph/docs/concepts/overview)
* [Microsoft Graph on Stack Exchange](https://stackoverflow.com/questions/tagged/microsoft-graph) with 'microsoft-graph' tag

## Typos, Issues, Bugs and Contributions

Whenever you are submitting any changes, please follow these recommendations.

* Always fork repository to your own account for applying modifications
* Do not combine multiple changes to one pull request, please submit for example any samples and documentation updates using separate PRs
* If you are submitting multiple samples, please create specific PR for each submission
* If you are submitting typo or documentation fix, you can combine modifications to single PR where suitable

## Sample Naming & Structure Guidelines

When you are submitting a new sample, it has to follow up below guidelines

* You will need to have a README file for your contribution, which is based on [provided template](../samples/README-template.md) under the Samples folder. Please copy this template and update accordingly. README has to be named as `README.md` with capital letters.
  * You will need to have a picture of the web part in practice in the README file ("pics or it didn't happen"). Preview image must be located in /assets/ folder in the root your you solution.
* When you update existing samples, please update also README accordingly with information on provided changes and with your author details
* When you are submitting new sample solution, please name the sample solution folder accordingly
  * Folder should start by identifying language / technology (`dotnet-calendarevents-list`), using terms such as:
    * `dotnet`
    * `java`
    * `js`
    * `ios`
    * `pnp`
  * If your solution is demonstrating multiple technologies, please use functional terms as the name for the solution folder
* Do not use period/dot in the folder name of the provided sample

## Submitting Pull Requests

Here's a high level process for submitting new samples or updates to existing ones.

1. Sign the Contributor License Agreement (see below)
1. Fork this repository [microsoftgraph/community-samples](https://github.com/microsoftgraph/community-samples) to your GitHub account
1. Create a new branch off the `master` branch for your fork for the contribution
1. Include your changes to your branch
1. Commit your changes using descriptive commit message * These are used to track changes on the repositories for monthly communications
1. Create a pull request in your own fork and target `master` branch
1. Fill up the provided PR template with the requested details

Before you submit your pull request consider the following guidelines:

* Search [GitHub](https://github.com/microsoftgraph/msgraph-community-samples/pulls) for an open or closed Pull Request
  that relates to your submission. You don't want to duplicate effort.
* Make sure you have a link in your local cloned fork to the [microsoftgraph/msgraph-community-samples](https://github.com/microsoftgraph/msgraph-community-samples):

  ```shell
  # check if you have a remote pointing to the Microsoft repo:
  git remote -v

  # if you see a pair of remotes (fetch & pull) that point to https://github.com/microsoftgraph/msgraph-community-samples, you're ok... otherwise you need to add one

  # add a new remote named "upstream" and point to the Microsoft repo
  git remote add upstream https://github.com/microsoftgraph/msgraph-community-samples.git
  ```

* Make your changes in a new git branch:

  ```shell
  git checkout -b dotnet-calendarevents-list master
  ```

* Ensure your fork is updated and not behind the upstream **msgraph-community-samples** repo. Refer to these resources for more information on syncing your repo:
  * [GitHub Help: Syncing a Fork](https://help.github.com/articles/syncing-a-fork/)
  * [Keep Your Forked Git Repo Updated with Changes from the Original Upstream Repo](http://www.andrewconnell.com/blog/keep-your-forked-git-repo-updated-with-changes-from-the-original-upstream-repo)
  * For a quick cheat sheet:

    ```shell
    # assuming you are in the folder of your locally cloned fork....
    git checkout master

    # assuming you have a remote named `upstream` pointing official **msgraph-community-samples** repo
    git fetch upstream

    # update your local master to be a mirror of what's in the main repo
    git pull --rebase upstream master

    # switch to your branch where you are working, say "dotnet-calendarevents-list"
    git checkout dotnet-calendarevents-list

    # update your branch to update it's fork point to the current tip of master & put your changes on top of it
    git rebase master
    ```

* Push your branch to GitHub:

  ```shell
  git push origin dotnet-calendarevents-list
  ```

### Submit Your Pull Request

* In GitHub, send a pull request to `msgraph-community-samples:master`.
  * If the PR is a fix to an open issue, include in the title or description of the PR a statement of either of the following to indicate what issue this PR is related to:
    * `Closes #000.`
    * `Fixes #000.`
    * `References #000.`
    * If it addresses multiple issues, please enter each of the above on the same line, but written as sentences like: `Closes #000. Closes #000.`
* If we suggest changes then:
  * Make the required updates.
  * Re-run the test suite to ensure tests are still passing.
  * Rebase your branch and force push to your GitHub repository (this will update your Pull Request):

    ```bash
    git rebase master -i
    git push -f
    ```

### After Your Pull Request is Merged

After your pull request is merged, you can safely delete your branch and pull the changes from the main (upstream) repository:

* Delete the remote branch on GitHub either through the GitHub web UI or your local shell as follows:

  ```shell
  git push origin --delete my-fix-branch
  ```

* Checkout & update the master branch:

  ```shell
  git checkout master -f
  git pull --ff upstream master
  ```

* Checkout & update the dev branch:

  ```shell
  git checkout dev -f
  git pull --ff upstream dev
  ```

* Delete the local branch:

  ```shell
  git branch -D my-fix-branch
  ```

## Signing the CLA

Before we can accept your pull requests you will be asked to sign electronically Contributor License Agreement (CLA), which is prerequisite for any contributions to PnP repository. This will be one time process, so for any future contributions you will not be asked to re-sign anything. After the CLA has been signed, our PnP core team members will have a look on your submission for final verification of the submission. Please do not delete your development branch until the submission has been closed.

You can find Microsoft CLA from the following address: https://cla.microsoft.com.

Thank you for your contribution.