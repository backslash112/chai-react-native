Chai App
--------

This is an ambitious project to create a full fledged news consumption app completely in Facebook's new React Platform for Android.
**This is a work in progress, highly experimental. Stay Tuned for Updates; and PRs are always welcome. **

setup
-----

follow getting started guide from react-native github

```
npm install -g react-native-cli
npm install
react-native run-android
```

if you get an error, in another window run
`adb reverse tcp:8081 tcp:8081`


COMPLETED
---------

1. We have an initial view that
	* loads json from http://chai.media/public_api/random/
	* renders it into a listview

TODOs
-----
1. User Login and User Settings Syncing with Backend Server
   * We need to lets a user log in with facebook and creates an account for him on our chai.media backend
   * we should be able to store user settings in an {key:value} with the backend and keep both of these in sync (updates can flow both ways)
   * in the app side, it should be in a way that anywhere in the rest of the app we can query for these user settings. (eg: get list of all favorite categories of logged in user) this should not need a network query to the backend.
   * Settings screen for user to check and update settings
      > enable / disable push notifications
      > choose favorite categories etc.

2. Main View of App
   * swipey toolbar with -> My News | Today's News | Trending
   * each section should be a good looking infinite scrolling cardview.
   * on click of an item we will open the items detail view; back should return to the user's position in the scroll
   * items must be cachable (1hr); i.e. you can expect new content only after an hour
   * pull to refresh to force refresh of the screen (optional?)

3. Detail View
   * This one view should behave differently depending on the type of content that is being requested to be shown in detail
   * if it an entity (eg: Trump / Google / India )
      > example: http://chai.media/channel/India/
   * if it is a news article 
      > example: http://chai.media/video/south-china-sea-dispute-china-builds-third-airstrip-at-mischief-reef-tomonews/
      * video play button will throw an intent to open the youtube video

