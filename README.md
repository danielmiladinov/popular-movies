# Welcome to Popular Movies!
### To Reviewers:
- Udacity reviewers, or anyone who wants to run this app on their devices, will first need to [create an account](https://www.themoviedb.org/account/signup) on [https://www.themoviedb.org/](https://www.themoviedb.org/) if they don't already have one, and request an [api key](https://www.themoviedb.org/settings/api).
- Next, create a string resource file: `app/src/main/res/values/secrets.xml`, with the following contents:
	```xml
	<?xml version="1.0" encoding="utf-8"?>
	<resources>
	    <string name="themoviedb_api_key_v3">$YOUR_API_KEY_HERE</string>
	</resources>
	```

### Project Overview

Most of us can relate to kicking back on the couch and enjoying a movie with friends and family. In this project, you’ll build an app to allow users to discover the most popular movies playing. We will split the development of this app in two stages. First, let's talk about stage 1.

In this stage you’ll build the core experience of your movies app.

Your app will:

-   Present the user with a grid arrangement of movie posters upon launch.
-   Allow your user to change sort order via a setting:
    -   The sort order can be by most popular or by highest-rated
-   Allow the user to tap on a movie poster and transition to a details screen with additional information such as:
    -   original title
    -   movie poster image thumbnail
    -   A plot synopsis (called overview in the api)
    -   user rating (called vote_average in the api)
    -   release date

### Why this Project?

To become an Android developer, you must know how to bring particular mobile experiences to life. Specifically, you need to know how to build clean and compelling user interfaces (UIs), fetch data from network services, and optimize the experience for various mobile devices. You will hone these fundamental skills in this project.

By building this app, you will demonstrate your understanding of the foundational elements of programming for Android. Your app will communicate with the Internet and provide a responsive and delightful user experience.