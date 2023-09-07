# Picnic Recruitment Task

Please read the following instructions carefully and make sure that you fulfil
all requirements listed.

## Overview

This is an Android programming assignment we've created specifically for our
recruitment process.
You were given a link to GitHub, which when you visited that link,
created a private fork of this repository. Only you and developers at Picnic
can see the code you push to this repository.

High-level instructions:

1. Read and follow the task specified below.
2. Make a local clone of this repository on your machine, and do your work on a
   branch other than `master`. Do not make any changes to the `master` branch.
3. Push your changes as frequently as you like to `origin/your-branch-name`,
   and create a pull request to merge your changes back into the `master`
   branch. Don't merge your pull request. Once you're finished with the
   assignment, we will do a code review of your pull request.
4. When you're finished, [create and add][github-labels] the label `done` to
   your pull request. This will notify us that your code is ready to be
   reviewed. Please do **NOT** publish your solution on a publicly available
   location (such as a public GitHub repository, your personal website, _et
   cetera_).

This process closely mimics our actual development and review cycle. We hope
you enjoy it!

## Task

We would like you to write code that will cover the functionality listed below and provide us with the source as well as the output of an Android app that consists of two screens:

![Wireframe][wireframe-image]

### Screen 1:

Screen 1 has the following two functionalities:

1. Displaying a random GIF:
   - Upon opening the app, it should connect to the Giphy random API and display a random GIF as displayed in **Fig 1**.
   - The random GIF displayed on this screen should be animated.
   - Every 10 seconds a new random GIF should replace the previous loaded one. This should continue as long as the user has no search results displayed.
   - **Screen 1** should also display the GIF title, link and an age restriction badge.
2. Search Bar:
   - Upon clicking the search bar, we start a live search after characters have been entered. This means that once the user has typed two characters, the search API should be called and not wait until the user pressed search.
   - The returning results should be displayed as shown in **Fig 2**. The GIFs’ in the search results do not have to be animated and the list doesn’t have to include infinite scrolling.
   - Tapping one of the list items should navigate the user to **Screen 2**.
   - This screen should be able to retain its state, in case the user navigates back to it from **Screen 2**.
   - On press of the back button, the screen should go back to displaying the random GIF.

### Screen 2:

Screen 2 only has the following functionality:

1. Displaying the GIF that was tapped:
   - On **Screen 2** the tapped GIF should be displayed animated along with the title, link and age restriction badge as displayed in **Fig 3**.
   - Upon tapping the back button, the user should be taken back to **Screen 1**.

### Useful information:

- API Documentation: https://developers.giphy.com/docs/
- Use the following API Key: `R0EwtB7exS59JghpNEieWQVxsZj6ULkl`
- Please, **DO NOT** use Giphy SDK https://github.com/Giphy/giphy-android-sdk-ui-example

### Extras:

- It’s okay to use any third party libraries you seem fit, but please attach a brief description of why you’ve selected it.
- The app should be written in Kotlin.
- Please also provide a brief description of the overall app architecture and the reasoning behind picking it over any other possible alternative.

### Grading Criteria:

You will be assessed on the following criteria:

- Architecture and approach
- Execution
- Testability
- Code readability and style
- Usage of git

_Thanks in advance for your time and interest in Picnic!_

[wireframe-image]: https://imgur.com/r72vQbz.png
[github-labels]: https://help.github.com/articles/about-labels
